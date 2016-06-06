package com.javaList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/31.
 */
public class ListDemo {

    public static void main(String[] args) {
        List<Integer> aList = new ArrayList<Integer>();
        aList.add(1);
        aList.add(2);
        aList.add(3);
        aList.add(4);

        List<Integer> bList = new ArrayList<Integer>();
        bList.add(4);
        bList.add(3);
        bList.add(2);

        //组合两个集合
        //aList.addAll(bList);

        /*
        List<Integer> theSameList = new ArrayList<Integer>();
        List<Integer> notTheSameList = new ArrayList<Integer>();
        for (Integer a : bList) {
            if (aList.contains(a)) {
                theSameList.add(a);
            } else {
                notTheSameList.add(a);
            }
        }
        */
        System.out.println(aList.containsAll(bList));


        //System.out.println(theSameList.toString());
        //System.out.println(notTheSameList.toString());
    }

}
