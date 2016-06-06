package com.http;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

/**
 * Http 请求
 * 1.设置请求头
 * 2.设置请求编码
 * 3.******
 * Created by Administrator on 2016/6/6.
 */
public class HttpRequestUtils {

    private static int connTime = 50000;

    private static int readTime = 50000;

    private static String charset = "UTF-8";

    /**
     * get 请求
     * @param url 请求地址url
     * @param charset 请求编码
     * @param connTime 连接超时时间 秒
     * @param readTime 响应超时时间 秒
     * @return String
     */
    public static String get(String url, String charset, Integer connTime, Integer readTime) {
        HttpClient httpClient = null;
        HttpGet httpGet = new HttpGet(url);
        String response = "";

        RequestConfig.Builder builder = RequestConfig.custom();
        if (connTime != null) {
            builder.setConnectTimeout(connTime);
        }

        if (readTime != null) {
            builder.setSocketTimeout(readTime);
        }
        RequestConfig config = builder.build();

        httpGet.setConfig(config);
        httpGet.addHeader("Content-Type", "application/json; charset=utf-8");
        httpGet.addHeader("Connection", "keep-alive");
        httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36");

        httpClient = HttpClientBuilder.create().build();
        InputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            HttpResponse result = httpClient.execute(httpGet);
            HttpEntity entity = result.getEntity();
            System.out.println("^^^^^^^^^获取编码类型:" + entity.getContentType());
            inputStream = entity.getContent();

            response = IOUtils.toString(inputStream, charset);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpGet.releaseConnection();
            try {
                ((CloseableHttpClient) httpClient).close();
                if (inputStream != null) {
                    inputStream.close();
                }

                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return response;
    }

}
