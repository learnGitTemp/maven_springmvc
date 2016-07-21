package com.test;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/21.
 */
@Repository("repairTomtopProductDaoImpl")
public class RepairTomtopProductDaoImpl implements RepairTomtopProductDao {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public String findNextById(String sql_name) {
        String sequence_collection = "seq";
        String sequence_field = "seq";
        DBCollection seq = this.mongoTemplate.getCollection(sequence_collection);
        BasicDBObject query = new BasicDBObject();
        query.put("_id", sql_name);
        BasicDBObject change = new BasicDBObject(sequence_field, Integer.valueOf(1));
        BasicDBObject update = new BasicDBObject("$inc", change);
        DBObject res = seq.findAndModify(query, new BasicDBObject(), new BasicDBObject(), false, update, true, true);
        return res.get(sequence_field).toString();
    }

    @Override
    public void insert(Object Object, String collectionName) {
        mongoTemplate.insert(Object, collectionName);
    }

    @Override
    public void createCollection(String collectionName) {

    }

    @Override
    public void remove(Map params, String collectionName) {

    }

    @Override
    public void update(Map params, String collectionName) {

    }

    @Override
    public List findAll(Map params, String collectionName) {
        return null;
    }

    @Override
    public Object findOne(Map params, String collectionName) {
        return null;
    }

    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
}
