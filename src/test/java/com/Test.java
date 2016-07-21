package com;

import com.http.HttpRequestUtils;
import com.orm.RepairTomtopProduct;
import com.test.RepairTomtopProductDao;
import com.test.RepairTomtopProductDaoImpl;
import com.tomtop.system.libraries.util.Json;
import com.ttm.util.Dumper;
import org.apache.commons.collections.CollectionUtils;
import org.junit.BeforeClass;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/21.
 */
public class Test {

    private static ClassPathXmlApplicationContext applicationContext;

    private static String collectionName;

    private static RepairTomtopProductDao repairTomtopProductDao;

    @BeforeClass
    public static void initSpring() {
        try {
            applicationContext = new ClassPathXmlApplicationContext("classpath:spring-config-mongodb.xml");
            repairTomtopProductDao = (RepairTomtopProductDaoImpl) applicationContext.getBean("repairTomtopProductDaoImpl");
            collectionName = "RepairTomtopProduct";
        } catch (Exception e) {
            System.out.println("^^^^^^^^^^^^^^^^^^^^^" + e);
        }
    }

    @org.junit.Test
    public void testAdd() {
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
        do {
            System.out.println("\n\n\n");
            Map<String, Object> request = new HashMap<String, Object>();
            request.put("pageSize", pageSize);
            request.put("page", pageNumber);
            request.put("webSiteId", 1);
            String response = (String) utils.post("http://consumer.api.tomtop.com/product/repair", request);
            List<Map<String, Object>> mTomtopProduct = (List<Map<String, Object>>) Json.fromJson(response, List.class);
            if (CollectionUtils.isNotEmpty(mTomtopProduct)) {
                for (Map<String, Object> repairTomtopProductMap : mTomtopProduct) {
                    System.out.println("listingId : " + repairTomtopProductMap.get("listingId"));
                    System.out.println("sku : " + repairTomtopProductMap.get("sku"));


                    RepairTomtopProduct nTomtopProduct = (RepairTomtopProduct) Json.fromJson(Json.toJson(repairTomtopProductMap), RepairTomtopProduct.class);
                    String s_ = repairTomtopProductDao.findNextById(collectionName);
                    nTomtopProduct.setId(Integer.valueOf(s_));
                    repairTomtopProductDao.insert(nTomtopProduct, collectionName);
                    //Dumper.dump(nTomtopProduct);
                }
            }

            System.out.println("^^^^^^^^^^^^^^^^^^pageNumber :" + pageNumber++);
        } while (pageNumber <= totalPage);
    }

}
