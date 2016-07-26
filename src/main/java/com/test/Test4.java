package com.test;

import com.http.HttpRequestUtils;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.orm.RepairTomtopProduct;
import com.tomtop.system.libraries.util.Json;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试反射
 * Created by Administrator on 2016/7/4.
 */
public class Test4 {

    public static void main(String[] args) throws UnknownHostException {
        HttpRequestUtils utils = new HttpRequestUtils();

        Integer pageNumber = 1;
        Integer pageSize = 3;
        Map<String, Object> request_count_ = new HashMap<String, Object>();
        request_count_.put("webSiteId", 1);
        String count = (String) utils.post("http://consumer.api.tomtop.com/product/repair/count", request_count_);
        Integer c_ = Integer.valueOf(count);
        Integer totalPage = c_ % pageSize == 0 ? c_ / pageSize : (c_ / pageSize) + 1;
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^ count :" + count);
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^ total :" + totalPage);

        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
        DB db = mongoClient.getDB("look23");
        MongoTemplate mongoTemplate = new MongoTemplate(db.getMongo(), "look23");
        RepairTomtopProductDao repairTomtopProductDao = new RepairTomtopProductDaoImpl();
        ((RepairTomtopProductDaoImpl) repairTomtopProductDao).setMongoTemplate(mongoTemplate);
        do {
            Map<String, Object> request = new HashMap<String, Object>();
            request.put("pageSize", pageSize);
            request.put("page", pageNumber);
            request.put("webSiteId", 1);
            String response = (String) utils.post("http://consumer.api.tomtop.com/product/repair", request);
            List<Map<String, Object>> mTomtopProduct = (List<Map<String, Object>>) Json.fromJson(response, List.class);
            if (CollectionUtils.isNotEmpty(mTomtopProduct)) {
                for (Map<String, Object> repairTomtopProductMap : mTomtopProduct) {
                    RepairTomtopProduct nTomtopProduct = (RepairTomtopProduct) Json.fromJson(Json.toJson(repairTomtopProductMap), RepairTomtopProduct.class);
                    String sId_ = repairTomtopProductDao.findNextById("RepairTomtopProduct");
                    nTomtopProduct.setId(Integer.valueOf(sId_));
                    repairTomtopProductDao.insert(nTomtopProduct, "RepairTomtopProduct");
                }
            }

            System.out.println("^^^^^^^^^^^^^^^^^^pageNumber :" + pageNumber++);
        } while (pageNumber <= totalPage);
    }

}
