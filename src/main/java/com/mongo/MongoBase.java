package com.mongo;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/20.
 */
public interface MongoBase<T> {

    public abstract void insert(T Object, String collectionName);

    public abstract T findOne(Map<String, Object> params, String collectionName);

    public abstract List<T> findAll(Map<String, Object> params, String collectionName);

    public abstract void update(Map<String, Object> params, String collectionName);

    public abstract void createCollection(String collectionName);

    public abstract void remove(Map<String, Object> params, String collectionName);


}
