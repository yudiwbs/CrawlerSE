package com.yuliadi;


/**
 * Created by yudiwbs on 14/01/2016.
 *
 *   proses JSON dari hasil API search engine Google
 *   dan simpan ke database. Nanti akan dicrawl
 *
 *   contoh JSONNYA:
 *   {"responseData": {"results":[{"GsearchResultClass":"GwebSearch","unescapedUrl":"http://www.airbus.com/newsevents/news-events-single/detail/relocating-to-innovate-the-airbus-wichita-kansas-engineering-centre-will-join-a-new-us-innovation-campus/","url":"http://www.airbus.com/newsevents/news-events-single/detail/relocating-to-innovate-the-airbus-wichita-kansas-engineering-centre-will-join-a-new-us-innovation-campus/","visibleUrl":"www.airbus.com",
 *   "cacheUrl":"http://www.google.com/search?q\u003dcache:ISp7akfN2MQJ:www.airbus.com","title":"Relocating to innovate: the \u003cb\u003eAirbus\u003c/b\u003e Wichita, Kansas \u003cb\u003eengineering\u003c/b\u003e \u003cb\u003e...\u003c/b\u003e","titleNoFormatting":"Relocating to innovate: the Airbus Wichita, Kansas engineering ...","content":"Apr 3, 2015 \u003cb\u003e...\u003c/b\u003e \u003cb\u003eAirbus plans\u003c/b\u003e to relocate its Wichita,
 *   Kansas-based \u003cb\u003edesign\u003c/b\u003e and \u003cb\u003eengineering\u003c/b\u003e \n\u003cb\u003ecentre\u003c/b\u003e from the operation\u0026#39;s current downtown Wichita location to a ..."}
 *
 *   yang diambil: unescapedUrl, url dan  titleNoFormatting
 *
 *   id_h
 *   unescapedUrl
 *   url
 *   titleNoFormatting
 *
 *
 */


public class ProsesJSON {

    public void proses(String jsonStr) {

    }

    public static void main(String[] args) {
        System.out.println("Proses JSON");
        //ProsesJSON pj = new ProsesJSON();
        //pj.proses("{\"responseData\": {\"results\":[{\"GsearchResultClass\":\"GwebSearch\",\"unescapedUrl\":\"https://en.wikipedia.org/wiki/Boeing_Canada\",\"url\":\"https://en.wikipedia.org/wiki/Boeing_Canada\",\"visibleUrl\":\"en.wikipedia.org\",\"cacheUrl\":\"http://www.google.com/search?q\\u003dcache:BSHNVHq2QAYJ:en.wikipedia.org\",\"title\":\"\\u003cb\\u003eBoeing Canada\\u003c/b\\u003e - Wikipedia, the free encyclopedia\",\"titleNoFormatting\":\"Boeing Canada - Wikipedia, the free encyclopedia\",\"content\":\"\\u003cb\\u003eHeadquarters\\u003c/b\\u003e, Winnipeg, \\u003cb\\u003eCanada\\u003c/b\\u003e ... \\u003cb\\u003eBoeing Canada\\u003c/b\\u003e is the \\u003cb\\u003eCanadian\\u003c/b\\u003e subsidiary \\nof \\u003cb\\u003eBoeing\\u003c/b\\u003e, with operations in Winnipeg, Richmond, British Columbia, Montreal ...\"},{\"GsearchResultClass\":\"GwebSearch\",\"unescapedUrl\":\"http://www.boeing.com/\",\"url\":\"http://www.boeing.com/\",\"visibleUrl\":\"www.boeing.com\",\"cacheUrl\":\"http://www.google.com/search?q\\u003dcache:pIsnqRZC868J:www.boeing.com\",\"title\":\"\\u003cb\\u003eBoeing\\u003c/b\\u003e: The \\u003cb\\u003eBoeing\\u003c/b\\u003e Company\",\"titleNoFormatting\":\"Boeing: The Boeing Company\",\"content\":\"Official corporate site, featuring information about the corporation and its products \\nand services, including airplanes, space systems, and integrated defense ...\"},{\"GsearchResultClass\":\"GwebSearch\",\"unescapedUrl\":\"https://www.linkedin.com/company/aeroinfo-systems\",\"url\":\"https://www.linkedin.com/company/aeroinfo-systems\",\"visibleUrl\":\"www.linkedin.com\",\"cacheUrl\":\"http://www.google.com/search?q\\u003dcache:CNTIGDWzoQAJ:www.linkedin.com\",\"title\":\"\\u003cb\\u003eBoeing Canada\\u003c/b\\u003e-AeroInfo | LinkedIn\",\"titleNoFormatting\":\"Boeing Canada-AeroInfo | LinkedIn\",\"content\":\"Learn about working at \\u003cb\\u003eBoeing Canada\\u003c/b\\u003e-AeroInfo. ... See who you know at \\u003cb\\u003eBoeing\\u003c/b\\u003e \\n\\u003cb\\u003eCanada\\u003c/b\\u003e-AeroInfo, leverage your professional network, and ... \\u003cb\\u003eHeadquarters\\u003c/b\\u003e.\"},{\"GsearchResultClass\":\"GwebSearch\",\"unescapedUrl\":\"https://www.aeroinfo.com/\",\"url\":\"https://www.aeroinfo.com/\",\"visibleUrl\":\"www.aeroinfo.com\",\"cacheUrl\":\"http://www.google.com/search?q\\u003dcache:1vYg_WryzH8J:www.aeroinfo.com\",\"title\":\"AeroInfo Systems Inc.\",\"titleNoFormatting\":\"AeroInfo Systems Inc.\",\"content\":\"At \\u003cb\\u003eBoeing Canada\\u003c/b\\u003e-AeroInfo, we\\u0026#39;re not just committed to developing innovative \\nsolutions for the aviation industry. We also help talented people realize their ...\"}],\"cursor\":{\"resultCount\":\"79,900\",\"pages\":[{\"start\":\"0\",\"label\":1},{\"start\":\"4\",\"label\":2},{\"start\":\"8\",\"label\":3},{\"start\":\"12\",\"label\":4},{\"start\":\"16\",\"label\":5},{\"start\":\"20\",\"label\":6},{\"start\":\"24\",\"label\":7},{\"start\":\"28\",\"label\":8}],\"estimatedResultCount\":\"79900\",\"currentPageIndex\":0,\"moreResultsUrl\":\"http://www.google.com/search?oe\\u003dutf8\\u0026ie\\u003dutf8\\u0026source\\u003duds\\u0026start\\u003d0\\u0026hl\\u003den\\u0026q\\u003dBoeing's+headquarters+is+in+Canada.++-.edu+-nltk+-linguistics+-nlp+-github+-entailment\",\"searchResultTime\":\"0.46\"}}, \"responseDetails\": null, \"responseStatus\": 200}");
    }

}
