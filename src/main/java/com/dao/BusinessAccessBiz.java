package com.dao;

/**
 * 业务层
 * Created by Administrator on 2016/4/6.
 */
public interface BusinessAccessBiz {

    /**
     * 保存并且返回 接口对象
     * @param object
     * @return
     */
    public abstract DateAccessDao saveObject(Object object);

}
