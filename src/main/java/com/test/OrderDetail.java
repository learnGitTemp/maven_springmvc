package com.test;

import com.http.HttpRequestUtils;

/**
 * Created by Administrator on 2016/6/7.
 */
public class OrderDetail {

    public static void main(String[] args) {
        String url = "http://consumer.api.tomtop.com/checkout/AN16F05M3251-ZSL00T/getOrder";
        String response = HttpRequestUtils.get(url, "utf-8", 10000, 10000);
        System.out.println(response);
    }

}
