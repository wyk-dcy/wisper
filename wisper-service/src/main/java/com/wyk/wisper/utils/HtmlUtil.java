package com.wyk.wisper.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author wuyongkang
 * @date 2021年09月09日 19:39
 */
public class HtmlUtil {
    public static void main(String[] args) throws IOException {
        String url ="https://search.jd.com/Search?keyword=java";
        Document parse = Jsoup.parse(new URL(url), 30000);
        Element element = parse.getElementById("J_goodsList");
        // System.out.println(element.html());
        Elements li = element.getElementsByTag("li");
        for (Element element1 : li) {
            String img = element1.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String price = element1.getElementsByClass("p-price").eq(0).text();
            String name = element1.getElementsByClass("p-name").eq(0).text();
            System.out.println("-------------------------------------------------------------");
            System.out.println(img);
            System.out.println(price);
            System.out.println(name);


        }


    }
}