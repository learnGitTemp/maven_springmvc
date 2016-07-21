package com.mongo;

import com.mongodb.MongoClient;
import com.mongodb.ReadPreference;
import com.mongodb.async.SingleResultCallback;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.net.UnknownHostException;

/**
 * Created by Administrator on 2016/7/12.
 */
public class mongodb {

    public static void main(String[] args) {
        mongodb mongodb = new mongodb();
        MongoCollection<Document> client = mongodb.getClient();
        mongodb.insert(client);
    }

    /**
     * 获取连接
     *
     * @return
     */
    private MongoCollection<Document> getClient() {
        MongoDatabase mongoDatabase = null;
        MongoClient mClient = null;
        try {
            mClient = new MongoClient("127.0.0.1", 27017);
//            mongoDatabase = mClient.getUsedDatabases();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return mongoDatabase.getCollection("look23");
    }

    public void insert(MongoCollection<Document> client) {
        Document document = new Document("name", "MongoDB")
                .append("type", "database")
                .append("count", 1)
                .append("info", new Document("x", 203).append("y", 102));
        client.insertOne(document);
//        client.withReadPreference(ReadPreference.secondary());
        System.out.println(client.count());
    }




}
