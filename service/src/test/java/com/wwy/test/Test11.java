package com.wwy.test;

import com.google.common.collect.Lists;

import java.util.List;

public class Test11 {
    public static void main(String[] args) {
        List<String> columnDroplistRequest = Lists.newArrayList("仙姑", "项目", "项目经验", "仙姑顾", "破旧沃恩", "沃恩发送到");
        Integer reduce = columnDroplistRequest.stream().map(String::length).reduce(Integer::max).get();
        System.out.println(reduce);

        String[] strArr = new String[]{"table_name", "project_id"};
        String join = String.join("`,`", strArr);
        System.out.println(join);
    }
}
