package com.test;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/30.
 */
public class SpecialCharacters {

    /**
     * 解密
     * @param text
     * @return
     */
    public String decryption(String text) {
        Map<String, String> specialMap = fetchReduction();
        text = getReplace(text, specialMap);
        return text;
    }

    /**
     * 循环替换
     * @param text
     * @param specialMap
     * @return
     */
    private String getReplace(String text, Map<String, String> specialMap) {
        for (String key : specialMap.keySet()) {
            if (text.contains(key)) {
                //"%20" 替换成 "-20"
                String replateStr = specialMap.get(key);
                text = StringUtils.replace(text, key, replateStr);
            }
        }
        return text;
    }

    /**
     * 加密方式
     * @param text
     * @return
     */
    public String encryption(String text){
        Map<String, String> specialMap = fetchSpe();
        text = getReplace(text, specialMap);
        return text;
    }

    /**
     * 获取特殊字符Map
     * @return
     */
    public Map<String, String> fetchSpe() {
        Map<String, String> special = new HashMap<String, String>();
        special.put("%23", "_23");
        special.put("%25", "_25");
        special.put("%26", "_26");
        special.put("%27", "_27");
        special.put("%28", "_28");
        special.put("%29", "_29");
        special.put("%2A", "_2A");
        special.put("%2f", "_2f");

        special.put("%5A", "_5A");
        special.put("%5C", "_5C");
        special.put("%5B", "_5B");
        special.put("%5D", "_5D");
        special.put("%5E", "_5E");
        special.put("%7B", "_7B");
        special.put("%7D", "_7D");
        special.put("%7C", "_7C");
        special.put("%2F", "_2F");
        return special;
    }

    /**
     * 还原
     * @return
     */
    public Map<String, String> fetchReduction() {
        Map<String, String> reduction = new HashMap<String, String>();
        reduction.put("_23", "#");
        reduction.put("_25", "%");
        reduction.put("_26", "&");
        reduction.put("_27", "'");
        reduction.put("_28", "(");
        reduction.put("_29", ")");
        reduction.put("_2A", "*");
        reduction.put("_2f", "/");

        reduction.put("_5C", "\\");
        reduction.put("_5B", "[");
        reduction.put("_5D", "]");
        reduction.put("_5E", "^");
        reduction.put("_7B", "{");
        reduction.put("_7D", "}");
        reduction.put("_7C", "|");
        reduction.put("_2F", "/");
        return reduction;
    }

}
