package com.xsl;

import com.ttm.util.Dumper;
import com.ttm.util.Excel;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.util.*;

/**
 * Created by Administrator on 2016/6/29.
 */
public class XlsExport {

    public static void main(String[] args) {
        XlsExport export = new XlsExport();
        Map<String, String> keyMap = export.parseKey(null);
        Map<String, String> valueMap = export.parseValue();
        Map<String, List<String>> relMap = export.parseRelationship();
        export.processData(keyMap, valueMap, relMap);
    }

    /**
     * 处理 关系 组合数据
     * @param keyMap
     * @param valueMap
     * @param relMap
     */
    public void processData(Map<String, String> keyMap, Map<String, String> valueMap, Map<String, List<String>> relMap) {
        List<Object> allMap = new ArrayList<Object>();
        for (String key : keyMap.keySet()) {
            Map<String, Object> map = new HashMap<String, Object>();
            //如果关系表中存在对应的key 就取出 key的value集合循环集合获取
            if (relMap.containsKey(key)) {
                List<String> valueIds = relMap.get(key);

                String keyName = keyMap.get(key);
                map.put(key, keyName);

                System.out.println("^^^^^^^^^^^^^^^^ size1:" + valueIds.size());
                List<Map<String, String>> valuesList = new ArrayList<Map<String, String>>();
                for (String valueId : valueIds) {
                    Map<String, String> newValue = new HashMap<String, String>();
                    if (valueMap.containsKey(valueId)) {
                        String valueName = valueMap.get(valueId);
                        newValue.put(valueId, valueName);
                        valuesList.add(newValue);
                    }
                }
                map.put("value", valuesList);
                allMap.add(map);
            }
        }
        Dumper.dump(allMap);
    }

    /**
     * 解析value值
     * @return
     */
    public Map<String, String> parseValue() {
        Map<String, String> valueNames = new HashMap<String, String>();
        Excel relExcel = new Excel("D://cc/t_attribute_value_namev2.xls");
        ArrayList<ArrayList<String>> excelArr = relExcel.toArray();

        int number = 1;
        for (ArrayList<String> rows : excelArr) {
            if (number == 1) {
                number++;
                continue;
            }

            String valueId = rows.get(2);
            String valueName = rows.get(3);

            if (StringUtils.isEmpty(valueId) || StringUtils.isEmpty(valueName)) {
                continue;
            }

            Object obj = valueNames.get(valueId);
            if (obj == null) {
                valueNames.put(valueId, valueName);
            }
        }
        return valueNames;
    }

    /**
     * 解析key 和 value之间id的关系
     * @return
     */
    public Map<String, List<String>> parseRelationship() {
        Map<String, List<String>> rel = new HashMap<String, List<String>>();
        Excel relExcel = new Excel("D://cc/t_attribute_valuev2.xls");
        ArrayList<ArrayList<String>> excelArr = relExcel.toArray();

        int number = 1;
        for (ArrayList<String> rows : excelArr) {
            if (number == 1) {
                number++;
                continue;
            }

            String keyId = rows.get(1);
            String valueId = rows.get(0);

            if (StringUtils.isEmpty(keyId) || StringUtils.isEmpty(valueId)) {
                continue;
            }

            List<String> valueIds = rel.get(keyId);
            if (CollectionUtils.isEmpty(valueIds)) {
                valueIds = new ArrayList<String>();
            }
            valueIds.add(valueId);
            rel.put(keyId, valueIds);
        }
        return rel;
    }

    /**
     * 解析key 如果args 有key值 就读取对应的 当个key进行另外两张表的查询
     * 如果 args null就读取整个文件
     * @param args
     * @return
     */
    public Map<String, String> parseKey(String args) {

        Map<String, String> keyNames = new HashMap<String, String>();
        if (StringUtils.isNotEmpty(args)) {
            String[] arg = StringUtils.split(args, ",");
            keyNames.put(arg[0], arg[1]);
        } else {
            Excel keyExcel = new Excel("D://cc/t_attribute_key_namev2.xls");
            keyNames = writerKeyExcel(keyNames, keyExcel);
        }

        return keyNames;
    }

    /**
     * 读取key配置文件
     * @param keyNames
     * @param excel
     */
    public Map<String, String> writerKeyExcel(Map<String, String> keyNames, Excel excel) {
        Map<String, String > count = new HashMap<String, String>();
        ArrayList<ArrayList<String>> excelArr = excel.toArray();
        System.out.println("^^^^^^^^^^^^^writerKeyExcel size: " + excelArr.size());
        int number = 1;
        for (ArrayList<String> rows : excelArr) {
            if (number == 1) {
                number++;
                continue;
            }

            String keyId = rows.get(1);
            String keyName = rows.get(3);

            if (StringUtils.isEmpty(keyId) || StringUtils.isEmpty(keyName)) {
                continue;
            }

            Object obj = count.get(keyId);
            if (obj == null) {
                count.put(keyId, keyName);
            }
        }
        return count;
    }

}
