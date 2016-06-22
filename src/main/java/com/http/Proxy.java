package com.http;

/**
 * 代理实体
 * Created by Administrator on 2016/6/22.
 */
public class Proxy {

    private String ip;  //代理 ip

    private Integer host;    //代理 host

    public Proxy() {}

    public Proxy(String ip, Integer host) {
        this.ip = ip;
        this.host = host;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getHost() {
        return host;
    }

    public void setHost(Integer host) {
        this.host = host;
    }
}
