package com.dao;

/**
 * 注册solr地址
 * Created by Administrator on 2016/4/7.
 */
public class SolrRegister {

    /**
     * 默认地址
     */
    private static String DEFAULT_SERVICE_PATH = "http://192.168.0.105:8983/solr";

    private String servicePath;

    public SolrRegister() {
//        System.out.println(System.getenv());

        /**
         * 这里使用的是java里面获取环境变量中值 也就是把对应的地址设置到环境变量中 在直接充环境变量中获取
         */
        servicePath = System.getenv("SOLR_HOME");
        System.out.println("^^^^^^^^^^^注册solr地址:" + servicePath);
        if (servicePath == null) {
            servicePath = SolrRegister.DEFAULT_SERVICE_PATH;
        }
    };

    public String getServicePath() {
        return servicePath;
    }

}
