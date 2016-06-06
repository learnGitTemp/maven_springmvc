package com.ttm.lambdas;

/**
 * 求总和
 * Created by Administrator on 2016/3/29.
 */
public class AddCommand implements Command {

    public void process(int[] target) {
        int number = 0;
        for (int x = 0; x < target.length; x++) {
            number += target[x];
        }
        System.out.println("数组元素总和:" + number);
    }

}
