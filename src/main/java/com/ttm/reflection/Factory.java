package com.ttm.reflection;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2016/7/3.
 */
public class Factory {

    private static Properties pro = new Properties();

    static {
        InputStream is = null;
        try {
            is = Factory.class.getClassLoader().getResourceAsStream("properties.properties");
            if (is == null) {
                System.out.println("^^^^^^^^^^^^^^^^^^^^^ 没有获取到对应流");
                throw new IOException();
            } else {
                pro.load(is);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Factory factory = new Factory();

    private Factory() {}

    public static Factory getFactory() {
        return factory;
    }

    public InterfaceTest getInterfaceTest() {
        InterfaceTest interfaceTest = null;

        String classInfo = pro.getProperty("test");
        try {
            Class<?> cla = Class.forName(classInfo);
            Object object = cla.newInstance();
            interfaceTest = (InterfaceTest) object;
        } catch (Exception  e) {
            e.printStackTrace();
        }
        return  interfaceTest;
    }



}
