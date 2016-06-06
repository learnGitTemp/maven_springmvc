package com.ttm.lambdas;

/**
 * 打印数组值
 * Created by Administrator on 2016/3/29.
 */
public class PrintCommand implements Command {

    @Override
    public void process(int[] target) {
        for (int temp : target) {
            System.out.println("迭代输出目标数组元素: " + temp);
        }
    }

}
