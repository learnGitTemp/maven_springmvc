package com.apach;

import org.apache.commons.collections.CollectionUtils;

import java.util.*;

/**
 * Created by Administrator on 2016/6/18.
 */
public class ArrSort {

    public static void main(String[] args) {
        List newList = new ArrayList();

        ArrSort as = new ArrSort();
        List<String> aList = new ArrayList<String>();
        aList.add("20");
        aList.add("2");
        aList.add("3");

        List<String> bList = new ArrayList<String>();
        bList.add("2");
        bList.add("3");
        bList.add("20");

        System.out.println(CollectionUtils.union(bList, aList));

        Map aMap = as.getCardinalityMap(aList);
        Map bMap = as.getCardinalityMap(bList);

        System.out.println("^^^^^^^^^^^^^^ aMap : " + aMap.toString());
        System.out.println("^^^^^^^^^^^^^^ bMap : " + bMap.toString());
        Set aSet = new HashSet(aList);
        aSet.addAll(bList);

        System.out.println("^^^^^^^^^^^^^^ aSet : " + aSet.toString());
        Iterator it = aSet.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            for (Integer x = 0, c = Math.max(as.getFreq(obj, aMap), as.getFreq(obj, bMap)); x < c; x++) {
                System.out.println("^" + c);
                newList.add(obj);
            }
        }

        System.out.println(newList);

        List<String> cList = new ArrayList<String>();
        cList.add("2");
        cList.add("2");
        cList.add("20");

        System.out.println(Arr.distinguishRemoval(cList));

    }

    public int getFreq(Object obj, Map freq) {
        Integer count = (Integer) freq.get(obj);
        if (count != null) {
            return count;
        }
        return 0;
    }

    /**
     * 获取容器中集合唯一值做Key 重复数量做value
     * 返回一个这样的映射形式
     * @param coll
     * @return
     */
    public Map getCardinalityMap(Collection coll) {
        Map count = new HashMap();
        for (Iterator it = coll.iterator(); it.hasNext(); ) {
            Object object = it.next();
            Integer c = (Integer) count.get(object);
            if (c == null) {
                count.put(object, 1);
            } else {
                count.put(object, c + 1);
            }
        }
        return count;
    }

}
