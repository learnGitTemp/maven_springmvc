package com.dao;

/**
 * 数据访问接口
 * Created by Administrator on 2016/4/6.
 */
public interface DateAccessDao {

    /**
     * 数据保存方法
     * @param object
     * @return
     */
    public abstract boolean save(Object object);

}
