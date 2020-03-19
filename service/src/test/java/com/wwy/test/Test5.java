package com.wwy.test;

public class Test5 {
    public static void main(String[] args) {
        int a = 1;
        a = a++;
        int b = a++;
        int c = a + ++a * a++;
        autoIncrement(c);
        System.out.println("a的值为："+ a);
        System.out.println("b的值为："+ b);
        System.out.println("c的值为："+ c);
    }

    public static void autoIncrement(int i){
        i++;
    }
}
