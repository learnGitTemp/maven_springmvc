package com.dao.impl;

import com.dao.BusinessAccessBiz;
import com.dao.DateAccessDao;

/**
 * Created by Administrator on 2016/4/6.
 */
public class AnQuanBiz implements BusinessAccessBiz {
    @Override
    public DateAccessDao saveObject(Object object) {
        AnQuanDao anQuanDao = new AnQuanDao();
        anQuanDao.save(object);
        return anQuanDao;
    }
}
