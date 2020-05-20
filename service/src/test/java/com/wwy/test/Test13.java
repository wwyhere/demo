package com.wwy.test;

public class Test13 {

    public static void main(String[] args) {
        int maxRank = 5;//最高等阶
        int everyOne = (int) Math.pow(2, maxRank - 1);//每一件所需的进阶数量

        int total = everyOne * 8;//需要的英雄装备总数，不包含武器衣服

        int current = 3;//当前已有的最高等阶数量

        int needTotal = (8 - current) * everyOne;

        //当前已有的1阶，2阶，3阶，4阶数量
        int one = 2;//2
        int tow = 2;//4
        int three = 1;//4
        int four = 5;//40

        int currentTotal = (int) (one * Math.pow(2, 0) + tow * Math.pow(2, 1) + three * Math.pow(2, 2) + four * Math.pow(2, 3));

        System.out.println(needTotal);
        System.out.println(currentTotal);

        System.out.println((needTotal - currentTotal) * 20);
    }
}
