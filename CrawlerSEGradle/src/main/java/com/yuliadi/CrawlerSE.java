package com.yuliadi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by yudiwbs on 12/01/2016.
 */

public class CrawlerSE {

    private void ambilData() {
        String usrName="yudilocal";
        String pwd="yudilocal";
        String dbName="searchengine";
        Connection conn=null;
        PreparedStatement pSel=null;
        ResultSet rs = null;
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            conn = DriverManager.getConnection("jdbc:mysql://localhost/"+dbName
                    + "?user="+usrName+"&password="+pwd);
            pSel = conn.prepareStatement("select id,t,h from rte3_babak2 " +
                    " where id=?");
            pSel.setString(1,"1");
            rs = pSel.executeQuery();
            while (rs.next()) {
                String nim = rs.getString(1);
                String nama = rs.getString(2);
                System.out.println(nim+","+nama);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void proses() {
        System.out.println("hello world hoho!");
    }

    public static void main(String[] args) {
        CrawlerSE cg = new CrawlerSE();
        cg.ambilData();

        //cg.proses();

        /*
          //sleep dengan waktu random
          //saat jalan crawl:
            //cek id terakhir yang sudah diproses, inc id
            //ambil berdasarkankan id, teks H yang akan diproses
            //panggil API
            //simpan hasil
            //tulis status
        */
    }
}
