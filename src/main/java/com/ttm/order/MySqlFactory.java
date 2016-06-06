package com.ttm.order;

import java.util.List;

/**
 * Created by Administrator on 2016/3/29.
 */
public interface MySqlFactory {

    public abstract boolean save(Class name, Object object);

    public abstract boolean delete(Class name, Object object);

    public abstract boolean update(Class name, Object object);

    public abstract Object findById(Class name, Object id);

    public abstract List<?> findByList(Class name);

}
