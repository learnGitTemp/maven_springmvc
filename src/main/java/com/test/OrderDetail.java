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
        String text = "那么问题来了，如果在外观上与6S相 & 差不大， #而且还彻底将3.5mm耳机插孔取消，这样的iPhone7你会购买吗?";
        text = URLEncoder.encode(text, "UTF-8");
        String url = "https://www.googleapis.com/language/translate/v2?q=" + text + "&target=en&source=zh&key=AIzaSyD7SqEMwWIRLxJP3IRyv4iUDoCSTomtgc8";

        Proxy proxy = new Proxy("120.76.31.181", 27739);
        HttpRequestUtils utils = new HttpRequestUtils();
        utils.setProxy(proxy);

        String response = utils.get(url);
        System.out.println(response);
    }

}
