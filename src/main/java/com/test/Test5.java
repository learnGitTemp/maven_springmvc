package com.test;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.orm.AnQuan;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/23.
 */
public class Test5 {

    public static void main(String[] args) throws UnknownHostException {
        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
        DB db = mongoClient.getDB("look23");
        MongoTemplate mongoTemplate = new MongoTemplate(db.getMongo(), "look23");
        RepairTomtopProductDao repairTomtopProductDao = new RepairTomtopProductDaoImpl();
        ((RepairTomtopProductDaoImpl) repairTomtopProductDao).setMongoTemplate(mongoTemplate);

        List<Integer> categoryId = new ArrayList<Integer>();
        categoryId.add(1);
        List<String> emails = new ArrayList<String>();
        emails.add("1252575758@qq.com");
        AnQuan anQuan = new AnQuan();
        anQuan.setId(Integer.valueOf(repairTomtopProductDao.findNextById("AnQuan")));
        anQuan.setName("小明");
        anQuan.setCategoryId(categoryId);
        anQuan.setEmail(emails);

        mongoTemplate.insert(anQuan, "AnQuan");
    }

}
