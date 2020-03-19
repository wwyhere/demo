package com.wwy.test;

import org.assertj.core.util.Lists;

import java.util.List;
import java.util.Stack;

public class Test9 {
    public static void main(String[] args) throws Exception {
        Integer 列a=1;
        Integer 列C=2;


        String foumla="#列a+#列C*$3+@count(@group(#列d,#表A.列e))";

        //常量$  列名#  函数@
        int length = foumla.length();
        StringBuilder stringBuilder=new StringBuilder();

        Stack<String> column = new Stack<String>(); //保存参数个数
        Stack<Character> bracket = new Stack<Character>(); //保存参数个数
        List<String> needReplace=Lists.newArrayList();

        List<Character> chars= Lists.newArrayList('(',')','+','-','*','/',',','@');

        for (int i = 0; i < length; i++) {
            char c = foumla.charAt(i);
            System.out.println("获取到的char为:"+c);
            if (c=='#'){
                //列名末端应该是操作符号
//                stringBuilder.append(c);
                for (int j = i+1; j < length; j++) {
                    char c1 = foumla.charAt(j);
                    i=j;
                    if (!chars.contains(c1)){
                        //列名结束
                        stringBuilder.append(c1);
                    }else{
                        column.push(stringBuilder.toString());
                        break;
                    }
                }
                System.out.println("列名:"+stringBuilder.toString());
                stringBuilder.setLength(0);
            }else if ((c=='@')){
                //先获取第一个(之后的，是否依然是函数

                for (int j = i+1; j < length; j++) {
                    char c1 = foumla.charAt(j);
                    if (c1=='('){
                        stringBuilder.append(c1);
                        bracket.push(c1);

//                        char c2 = foumla.charAt(j + 1);
//                        if (c2=='@'){
//                            //依然是函数，则校验是否是组合函数，是组合函数，转化sql，不是，则先计算里面的
//                        }
//                        break;
                    }else if (c1==')'){
                        i=j;
                        stringBuilder.append(c1);
                        Character pop = bracket.pop();
                        if (pop!=null){
                            continue;
                        }else{
                            //函数结束
                            break;
                        }
                    }else {
                        stringBuilder.append(c1);
                    }
                }


//                for (int j = i+1; j < length; j++) {
//                    char c1 = foumla.charAt(j);
//                    i=j;
//                    if (!chars.contains(c1)){
//                        //列名结束
//                        stringBuilder.append(c1);
//                    }else{
//                        needReplace.add(stringBuilder.toString());
//                        break;
//                    }
//                }
                System.out.println("函数名:"+stringBuilder.toString());
                stringBuilder.setLength(0);
            }else if ((c=='$')){
                for (int j = i+1; j < length; j++) {
                    char c1 = foumla.charAt(j);
                    i=j;
                    //常量
                    if (!chars.contains(c1)){
                        //列名结束
                        stringBuilder.append(c1);
                    }else{
                        break;
                    }
                }
                needReplace.add(stringBuilder.toString());
                System.out.println("常量:"+stringBuilder.toString());
                stringBuilder.setLength(0);
            }else if ((c=='(')){

            }else if ((c==')')){

            }else{
                throw new Exception("语法错误");
            }
        }
    }
}
