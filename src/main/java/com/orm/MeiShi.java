package com.orm;

import org.apache.solr.client.solrj.beans.Field;

/**
 * Created by Administrator on 2016/4/6.
 */
public class MeiShi {

    @Field
    private Integer id;

    @Field
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
