package com.dao;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.UpdateResponse;

import java.io.IOException;

/**
 * solr数据处理对象 用于处理数据使用
 * Created by Administrator on 2016/4/7.
 */
public class SolrDao {

    private String servicePath;

    private SolrServer server;

    private SolrRegister register = new SolrRegister();

    public String getServicePath() {
        return servicePath;
    }

    public boolean saveSolr(Object object) {
        //1.首先 获取请求solr地址
        //2.添加 实体
        //3.进行solr数据持久化操作
        //4.判断是否实体添加是否成功状态
        System.out.println("^^^^^^^^^^^^^save:" + register.getServicePath());
        server = new HttpSolrServer(register.getServicePath());
        try {
            UpdateResponse updateResponse = server.addBean(object);
            server.commit();

            System.out.println("status:" + updateResponse.getStatus());
            if (updateResponse.getStatus() == 0) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
        return false;
    }

}
