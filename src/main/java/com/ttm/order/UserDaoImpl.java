package com.ttm.order;

import java.util.List;

/**
 * Created by Administrator on 2016/3/29.
 */
public class UserDaoImpl implements MySqlFactory {

    private MySqlFactoryProcess process = new MySqlFactoryProcess();

    @Override
    public boolean save(Class name, Object object) {
        return process.saveEntity(name, object, this);
    }

    @Override
    public boolean delete(Class name, Object object) {
        return process.deleteEntity(name, object, this);
    }

    @Override
    public boolean update(Class name, Object object) {
        return process.updateEntity(name, object, this);
    }

    @Override
    public Object findById(Class name, Object id) {
        return null;
    }

    @Override
    public List<?> findByList(Class name) {
        return null;
    }
}
