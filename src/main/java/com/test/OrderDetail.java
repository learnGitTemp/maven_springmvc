package com.test;

import com.http.HttpRequestUtils;
import com.http.Proxy;
import com.ttm.util.Dumper;
import com.ttm.util.Json;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/7.
 */
public class OrderDetail {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String text = "Hello / World / !";
        text = URLEncoder.encode(text, "UTF-8");
        System.out.println("^^^^^^^^^^^^:" + text);
        SpecialCharacters sc = new SpecialCharacters();
        System.out.println(sc.encryption(text));
        //Dumper.dump(sc.encryption(text));
        String url = "https://www.googleapis.com/language/translate/v2?q=" + sc.encryption(text) + "&target=zh&source=en&key=AIzaSyD7SqEMwWIRLxJP3IRyv4iUDoCSTomtgc8";

        String url2 = "https://www.googleapis.com/language/translate/v2?q=So+the+_34+question+is%2C+if+the+phase+%26amp%3B+6S+little+difference+in+appearance%2C+but+also+-+will+be+completely+canceled+3.5mm+headphone+jack%2C+so+iPhone7+you+buy+it%3F&target=fr&source=en&key=AIzaSyD7SqEMwWIRLxJP3IRyv4iUDoCSTomtgc8";
        Proxy proxy = new Proxy("120.76.31.181", 27739);
        HttpRequestUtils utils = new HttpRequestUtils();
        utils.setProxy(proxy);

        String response = utils.get(url);
        Map<String, Object> mMap = (Map<String, Object>) Json.fromJson(response, Map.class);
        Map<String, Object> mMap2 = (Map<String, Object>) mMap.get("data");
        List<Map<String, Object>> lList = (List<Map<String, Object>>) mMap2.get("translations");
        String translatedText = (String) lList.get(0).get("translatedText");
        System.out.println(sc.decryption(translatedText));
    }

}
