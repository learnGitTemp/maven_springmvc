package com.dao.impl;

import com.dao.BusinessAccessBiz;
import com.dao.DateAccessDao;

/**
 * Created by Administrator on 2016/4/6.
 */
public class MeiShiBiz implements BusinessAccessBiz {
    @Override
    public DateAccessDao saveObject(Object object) {
        MeiShiDao meiShiDao = new MeiShiDao();
        meiShiDao.save(object);
        return meiShiDao;
    }
}
