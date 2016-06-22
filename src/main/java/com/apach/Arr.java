package com.apach;

import org.apache.commons.collections.CollectionUtils;

import java.util.*;

/**
 * Created by Administrator on 2016/6/19.
 */
public class Arr {

    /**
     * 去除元素中的重复元素
     * @param aColl
     * @param bColl
     * @return
     */
    public static List removalRepeat(Collection aColl, Collection bColl) {
        Set mSet = new HashSet(aColl);
        mSet.addAll(bColl);
        return new ArrayList(mSet);
    }

    /**
     * 获取特有元素 / 重复元素 以Map形式输出
     * @param aColl
     * @return
     */
    public static Map distinguishRemoval(Collection aColl) {
        Map newMap = new HashMap();
        Map aMap = CollectionUtils.getCardinalityMap(aColl);
        List removal = new ArrayList();
        List union = new ArrayList();

        Iterator it = aMap.keySet().iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            int count = (int) aMap.get(obj);
            if (count > 1) {
                union.add(obj);
            } else {
                removal.add(obj);
            }
        }
        newMap.put("removal", removal);
        newMap.put("union", union);
        return newMap;
    }

}
