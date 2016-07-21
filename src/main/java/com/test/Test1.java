package com.test;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.net.UnknownHostException;

/**
 * Created by Administrator on 2016/6/12.
 */
public class Test1 {

    static {
        b = 6;
    }

    static int a = 5;
    static int b = 9;
    static int c;

    public static void main(String[] args) throws UnknownHostException {
        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
        DB db = mongoClient.getDB("look23");
        MongoTemplate mongoTemplate = new MongoTemplate(db.getMongo(), "look23");

    }

}
