package com.test;

import com.http.HttpRequestUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Administrator on 2016/6/7.
 */
public class OrderDetail {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String text = "google-api-translate-java is distributed in the hope that it will be useful,\n" +
                " * & but WITHOUT ANY WARRANTY; without even the implied warranty of\n" +
                " *  & #MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the\n" +
                " * GNU General Public License for more details.";
        text = URLEncoder.encode(text, "UTF-8");
        System.out.println("^^^^^^^^^^^^^^^^^fig 001" + text);
        String url = "https://www.googleapis.com/language/translate/v2?q=" + text + "&target=zh&source=en&key=AIzaSyD7SqEMwWIRLxJP3IRyv4iUDoCSTomtgc8";
        String response = HttpRequestUtils.get(url, "UTF-8", 50000, 50000);
        System.out.println(response);
    }

}
