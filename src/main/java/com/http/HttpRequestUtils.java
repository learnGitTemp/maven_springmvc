package com.http;

import org.apache.commons.codec.net.URLCodec;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.ssl.SSLContextBuilder;

import javax.net.ssl.SSLContext;
import java.io.*;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Http 请求
 * 1.设置请求头
 * 2.设置请求编码
 * 3.*****
 * Created by Administrator on 2016/6/6.
 */
public class HttpRequestUtils {

    private static int connTime = 50000;

    private static int readTime = 50000;

    private static String charset = "UTF-8";

    public static String get(String url, String params, String charset, Integer connTime, Integer readTime) {
        HttpClient httpClient = null;

        System.out.println(url);
        HttpGet httpGet = new HttpGet(url);
        String response = "";

        RequestConfig.Builder builder = RequestConfig.custom();
        if (connTime != null) {
            builder.setConnectTimeout(connTime);
        }

        if (readTime != null) {
            builder.setSocketTimeout(readTime);
        }
        builder.setProxy(new HttpHost("120.76.31.181", 27739));
        RequestConfig config = builder.build();

        httpGet.setConfig(config);
        httpGet.addHeader("Content-Type", "charset=utf-8");
        httpGet.addHeader("Connection", "keep-alive");
        httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36");

        if (StringUtils.startsWith(url, "https")) {
            httpClient = createSslHttpClient();
        } else {
            httpClient = HttpClientBuilder.create().build();
        }

        InputStream inputStream = null;
        try {
            HttpResponse result = httpClient.execute(httpGet);
            HttpEntity entity = result.getEntity();
            System.out.println("^^^^^^^^^获取编码类型:" + entity.getContentType());
            inputStream = entity.getContent();

            response = IOUtils.toString(inputStream, charset);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            httpGet.releaseConnection();
            try {
                ((CloseableHttpClient) httpClient).close();
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return response;
    };

    /**
     * get 请求
     *
     * @param url      请求地址url
     * @param charset  请求编码
     * @param connTime 连接超时时间 秒
     * @param readTime 响应超时时间 秒
     * @return String
     */
    public static String get(String url, String charset, Integer connTime, Integer readTime) throws UnsupportedEncodingException {
        HttpClient httpClient = null;

        System.out.println(url);
        HttpGet httpGet = new HttpGet(url);
        String response = "";

        RequestConfig.Builder builder = RequestConfig.custom();
        if (connTime != null) {
            builder.setConnectTimeout(connTime);
        }

        if (readTime != null) {
            builder.setSocketTimeout(readTime);
        }
        builder.setProxy(new HttpHost("120.76.31.181", 27739));
        RequestConfig config = builder.build();

        httpGet.setConfig(config);
        httpGet.addHeader("Content-Type", "charset=utf-8");
        httpGet.addHeader("Connection", "keep-alive");
        httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36");

        if (StringUtils.startsWith(url, "https")) {
            httpClient = createSslHttpClient();
        } else {
            httpClient = HttpClientBuilder.create().build();
        }

        InputStream inputStream = null;
        try {
            HttpResponse result = httpClient.execute(httpGet);
            HttpEntity entity = result.getEntity();
            System.out.println("^^^^^^^^^获取编码类型:" + entity.getContentType());
            inputStream = entity.getContent();

            response = IOUtils.toString(inputStream, charset);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            httpGet.releaseConnection();
            try {
                ((CloseableHttpClient) httpClient).close();
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return response;
    }

    /**
     * post 请求
     *
     * @param url      请求地址url
     * @param charset  请求编码
     * @param connTime 连接超时时间 秒
     * @param readTime 响应超时时间 秒
     * @param body     请求类型
     * @param type     例如 application/xml "application/x-www-form-urlencoded" a=1&b=2&c=3
     * @return String
     */
    public static String post(String url, String charset, Integer connTime, Integer readTime, String body, String type) {
        HttpClient httpClient = null;
        HttpEntity entity = null;
        HttpPost httpPost = new HttpPost(url);
        String response = "";

        if (StringUtils.isNotEmpty(body)) {
            entity = new StringEntity(body, ContentType.create(type, charset));
        } else {
            entity = new StringEntity(body, ContentType.APPLICATION_JSON);
        }

        RequestConfig.Builder builder = RequestConfig.custom();
        if (connTime != null) {
            builder.setConnectTimeout(connTime);
        }

        if (readTime != null) {
            builder.setSocketTimeout(readTime);
        }
        RequestConfig config = builder.build();
        httpPost.setConfig(config);
        httpPost.addHeader("Content-Type", "application/json; charset=utf-8");
        httpPost.addHeader("Connection", "keep-alive");
        httpPost.setEntity(entity);

        if (StringUtils.startsWith(url, "https")) {
            httpClient = createSslHttpClient();
        } else {
            httpClient = HttpClientBuilder.create().build();
        }

        try {
            HttpResponse result = httpClient.execute(httpPost);
            HttpEntity resultEntity = result.getEntity();

            InputStream inputStream = null;
            inputStream = resultEntity.getContent();
            response = IOUtils.toString(inputStream, charset);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return response;
    }

    public static CloseableHttpClient createSslHttpClient() {
        CloseableHttpClient closeableHttpClient = null;
        try {
            SSLContext sslContext = null;
            try {
                sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                    @Override
                    public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                        return false;
                    }
                }).build();
            } catch (KeyManagementException e) {
                e.printStackTrace();
            }

            SSLConnectionSocketFactory factory = new SSLConnectionSocketFactory(sslContext);

            closeableHttpClient = HttpClientBuilder.create().setSSLSocketFactory(factory).build();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        return closeableHttpClient;
    }

}
