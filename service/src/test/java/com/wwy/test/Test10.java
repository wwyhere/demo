package com.wwy.test;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.UUID;

public class Test10 {
    public static void main(String[] args) {
        String str="-5.5";
        boolean number = NumberUtils.isNumber(str);
        System.out.println(number);
        boolean digits = NumberUtils.isDigits(str);
        System.out.println(digits);


        boolean numeric = StringUtils.isNumeric(str);
        System.out.println(numeric);

//        String str="安宏伟a1(b3";
//        if(str.replaceAll("[\u4e00-\u9fa5]*[a-z]*[A-Z]*\\d*-*_*\\s*", "").length()==0){
//            //如果不包含特殊字符
//            System.out.println("没有特殊字符");
//        }else{
//            System.out.println("包含了特殊字符");
//        }
    }
}
