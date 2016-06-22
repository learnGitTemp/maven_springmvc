package com.test;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * Created by Administrator on 2016/6/12.
 */
public class Test2 {

    public static void main(String[] args) throws IOException {
        ClassLoader sysoutLoader = ClassLoader.getSystemClassLoader();
        System.out.println("ClassLoader:" + sysoutLoader);

        Enumeration<URL> em1 = sysoutLoader.getResources("");
        while (em1.hasMoreElements()) {
            System.out.println(em1.nextElement());
        }
    }

}
