package com.wwy.test;

import com.google.common.collect.Lists;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        //800个  每小时6点
        //每小时8点
        //多少个小时，可以追上消耗点
        //假设x个小时，追上800个
        //800个需要100个小时
        //800个需要133个小时

        //x个小时，800+6x=8x
        //800=2x;
        //x=400

        int h = 1;
        List<Integer> list = Lists.newArrayList();
        List<Integer> list2 = Lists.newArrayList();
        List<Integer> list3 = Lists.newArrayList();
        for (int i = 1; i < 200; i++) {
            System.out.println(String.format("第%d次合服，%d与%d合为%d", h, i, i + 1, i));
            list.add(i);
            i++;
        }
        h++;
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(String.format("第%d次合服，%d与%d合为%d", h, list.get(i), list.get(i+1), list.get(i)));
            list2.add(list.get(i));
            i++;
        }
        System.out.println(list2);
        h++;
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(String.format("第%d次合服，%d与%d合为%d", h, list2.get(i), list2.get(i+1), list2.get(i)));
            list3.add(list2.get(i));
            i++;
        }
        System.out.println(list3);
    }
}
