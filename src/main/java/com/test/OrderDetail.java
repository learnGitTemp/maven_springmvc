package com.test;

import com.http.HttpRequestUtils;
import com.http.Proxy;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Administrator on 2016/6/7.
 */
public class OrderDetail {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String text = "So the question is, if the phase &amp; 6S little difference in appearance, but also # will be completely canceled 3.5mm headphone jack, so iPhone7 you buy it?";
        text = URLEncoder.encode(text, "UTF-8");
        String url = "https://www.googleapis.com/language/translate/v2?q=" + text + "&target=zh&source=en&key=AIzaSyD7SqEMwWIRLxJP3IRyv4iUDoCSTomtgc8";

        String url2 = "https://www.googleapis.com/language/translate/v2?q=So+the+question+is%2C+if+the+phase+%26amp%3B+6S+little+difference+in+appearance%2C+but+also+-+will+be+completely+canceled+3.5mm+headphone+jack%2C+so+iPhone7+you+buy+it%3F&target=fr&source=en&key=AIzaSyD7SqEMwWIRLxJP3IRyv4iUDoCSTomtgc8";
        Proxy proxy = new Proxy("120.76.31.181", 27739);
        HttpRequestUtils utils = new HttpRequestUtils();
        utils.setProxy(proxy);

        String response = utils.get(url2);
        System.out.println(response);
    }

}
