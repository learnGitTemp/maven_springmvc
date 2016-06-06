package com.ttm.order;

import java.util.List;

/**
 * Created by Administrator on 2016/3/29.
 */
public class MySqlFactoryProcess {

    public boolean saveEntity(Class name, Object object, MySqlFactory factory) {
        System.out.println("saveEntity:" + name.getName());
        return factory.save(name, object);
    };

    public boolean deleteEntity(Class name, Object object, MySqlFactory factory) {
        System.out.println("deleteEntity:" + name.getName());
        return factory.delete(name, object);
    }

    public boolean updateEntity(Class name, Object object, MySqlFactory factory) {
        System.out.println("updateEntity:" + name.getName());
        return factory.delete(name, object);
    }

    public Object findById(Class name, Object id, MySqlFactory factory) {
        System.out.println("findById:" + name.getName());
        return factory.findById(name, id);
    }

    public List<?> findByList(Class name, MySqlFactory factory) {
        System.out.println("findByList:" + name.getName());
        return factory.findByList(name);
    }

}
