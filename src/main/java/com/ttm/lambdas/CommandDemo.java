package com.ttm.lambdas;

/**
 * 测试类
 * Created by Administrator on 2016/3/29.
 */
public class CommandDemo {

    public static void main(String[] args) {
        int[] tempA = {1, 2, 4, 5, 6};
        CommandArray commandArray = new CommandArray();
        //打印
        Command printCom = new PrintCommand();
        printCom.process(tempA);

        //计算和
        Command addCom = new AddCommand();
        addCom.process(tempA);
    }

}
