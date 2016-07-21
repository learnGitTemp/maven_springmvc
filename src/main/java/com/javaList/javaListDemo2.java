package com.javaList;

import com.orm.MeiShi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 2016/7/12.
 */
public class javaListDemo2 {

    public static void main(String[] args) {
        MeiShi meiShi = new MeiShi();
        meiShi.setId(123);
        meiShi.setName("123");
        MeiShi meiShi1 = new MeiShi();
        meiShi1.setId(456);
        meiShi1.setName("456");
        MeiShi meiShi2 = new MeiShi();
        meiShi2.setId(1);
        meiShi2.setName("1");
        MeiShi meiShi3 = new MeiShi();
        meiShi3.setId(6);
        meiShi3.setName("6");
        List<MeiShi> meiShiList = new ArrayList<MeiShi>();
        meiShiList.add(meiShi);
        meiShiList.add(meiShi1);
        meiShiList.add(meiShi2);
        meiShiList.add(meiShi3);
        Integer a = 0;
        Collections.reverseOrder();
        Collections.sort(meiShiList, new Comparator<MeiShi>() {
            public int compare(MeiShi o1, MeiShi o2) {
                int number = 0;
                if (o1.getId() > o2.getId()) {
                    number = -1;
                } else if (o1.getId() < o2.getId()) {
                    number = 1;
                }
                return number;
            }
        });
        for (MeiShi mMeishi : meiShiList) {
            System.out.println("^^^^^^^^^^^id : " + mMeishi.getId());
        }
    }

}



