package com.dao.impl;

import com.dao.DateAccessDao;

/**
 * Created by Administrator on 2016/4/6.
 */
public class MeiShiDao implements DateAccessDao {
    @Override
    public boolean save(Object object) {
        System.out.println("获取的实体名称是" + object.getClass().getSimpleName() + " ，现在进行保存");
        return true;
    }
}
