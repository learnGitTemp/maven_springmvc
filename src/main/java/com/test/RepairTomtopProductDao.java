package com.test;

import com.mongo.MongoBase;

/**
 * Created by Administrator on 2016/7/21.
 */
public interface RepairTomtopProductDao extends MongoBase {

    public abstract String findNextById(String sql_name);

}
