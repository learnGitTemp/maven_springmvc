package com.test;

import com.orm.MeiShi;

import java.io.File;
import java.lang.reflect.Field;

/**
 * 访问成员变量值
 * Created by Administrator on 2016/6/15.
 */
public class Test3 {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        MeiShi meiShi = new MeiShi();
        Field idField = MeiShi.class.getDeclaredField("id");
        idField.setAccessible(true);
        idField.set(meiShi, 1);

        Field nameField = MeiShi.class.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(meiShi, "小明");

        System.out.println(meiShi);

    }

}
