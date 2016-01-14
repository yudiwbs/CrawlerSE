package com.yuliadi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.util.Date;

/**
 * Created by yudiwbs on 12/01/2016.
 *
 *  Menggunakan database, ambil hipotesis lalu gunakan google search API untuk
 *  mendapatkan hasil search, lalu disimpan ke DB dalam bentuk JSON
 *
 *  proses didelay secara random supaya tdk dianggan spam oleh Google
 *
 *
 *
 */

public class CrawlerSE {
    private Connection conn=null;
    private String usrName="yudilocal";
    private String pwd="yudilocal";
    private String dbName="searchengine";
    private PreparedStatement pSel=null;
    private PreparedStatement pIns=null;

    @Override
    public void finalize() {
        close();
    }

    public void close() {
        try {
           if (conn != null)  {
                conn.close();
            }
        }
        catch (Exception e) {
           e.printStackTrace();
        }
    }

    private void init() {
        //connect ke DB, siapkan preparedstatements
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/"+dbName
                    + "?user="+usrName+"&password="+pwd);
            //siapakn query untuk mengambil id dan hs
            pSel = conn.prepareStatement("select id,h from rte3_babak2 " +
                    " where status_proses is null limit 1");
            pIns = conn.prepareStatement("update rte3_babak2 " +
                    "set hasil_search=?, status_proses=1, timestamp_proses=? where id=?");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String urlReader(String s) throws IOException {
            StringBuilder sb = new StringBuilder();
            URL u;
             try {
                u = new URL("https://ajax.googleapis.com/ajax/services/search/web?v=1.0&q="+s+"++-.edu+-nltk+-linguistics+-nlp+-github+-entailment");
                BufferedReader in = new BufferedReader(new InputStreamReader(u.openStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    sb.append(inputLine);
                    //System.out.println(inputLine);
                }
                in.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return sb.toString();
    }


    //ambil id dan Hipotesis
    private void prosesH() {
        ResultSet rs = null;
        try {
            //pSel.setString(1,"1");
            rs = pSel.executeQuery();
            String h="";
            int id=-1;
            while (rs.next()) { //pasti dapat 1
                id  = rs.getInt(1);
                h = rs.getString(2);
                System.out.println(id+":"+h);
            }

            if (h.equals("")) {
                //nggak boleh kosong!
                System.out.println("Error: h kosong");
                return;
            }

            //konversi H ke bentuk valid URL
            //contoh,
            // input:
            // Capt. Scott reached Scott Island in December 1902  -.edu -nltk -linguistics -nlp -github -entailment
            // output:
            // Capt.+Scott+reached+Scott+Island+in+December+1902++-.edu+-nltk+-linguistics+-nlp+-github+-entailment&oq=Capt.+Scott+reached+Scott+Island+in+December+1902++-.edu+-nltk+-linguistics+-nlp+-github+-entailment
            String parH = java.net.URLEncoder.encode(h, "utf-8");

            //panggil API google, hasilnya simpan
            String hasilSE = urlReader(parH);
            //System.out.println("hasil crawl:"+hasilSE);

            //save ke DB

            //"update rte3_babak2 " +
            //"set hasilsearch=?,
            //     isproses=1,
            //     timestamp=? where id=?");

            java.util.Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            pIns.setString(1,hasilSE);
            pIns.setTimestamp(2, timestamp);
            pIns.setInt(3,id);
            pIns.execute();
            rs.close();
            //koneksi ditutup di method close()
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int randomWithRange(int min, int max)
    {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

    //dalam menit
    public int waktuTunggu() {
        int out=13; //nilai aman

        //tentukan dulu diantara 3
        //pendek 5 menit
        //menengah 15 menit
        //panjang 30 menit

        int[] arrBatasWaktu = new int[3];
        arrBatasWaktu[0]  = 7;
        arrBatasWaktu[1] = 17;
        arrBatasWaktu[2] = 25;

        //setelah itu baru tentukan random dalam rentang +- 30%
        int pil = randomWithRange(0,2);
        int batas = (int) Math.round(arrBatasWaktu[pil]*0.3);
        int batasAtas  = arrBatasWaktu[pil]+batas;
        int batasBawah = arrBatasWaktu[pil]-batas;
        //System.out.println("batas atas  ="+batasAtas);
        //System.out.println("batas bawah ="+batasBawah);
        out = randomWithRange(batasBawah,batasAtas);
        return out;
    }

    public void proses() {
        System.out.println("Mulai memproses crawl!");

        // nanti loop sampai 800
        init();
        //untuk test, satu kali dulu
        for (int i=0;i<10;i++) {
            try {
                //debug, sleep satu menit dulu
                //waktu = 1; //DEBUG, nanti dibuang!
                int waktu = waktuTunggu();
                System.out.println("Waktu tunggu:" + waktu);
                System.out.println("Sleep dulu selama:"+waktu);
                Thread.sleep(waktu*1000*60);  //sleep baru crawl, sleep dalam menit
                prosesH();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        close();
    }

    private void coba() {
        try {
            String out = java.net.URLEncoder.encode("Capt. Scott reached Scott Island in December 1902  -.edu -nltk -linguistics -nlp -github -entailment", "utf-8");
            System.out.println(out);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CrawlerSE cg = new CrawlerSE();
        cg.proses();
    }
}
