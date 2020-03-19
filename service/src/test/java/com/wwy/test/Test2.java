package com.wwy.test;

public class Test2 {
    public static void main(String[] args) {
        int pow = (int) (Math.pow(2, 5));
        System.out.println(pow);
        int y=10%pow;
        int z=pow>>1;
        System.out.println(y);
        System.out.println(z);
    }

    public static String getValue(Object object) {
        if (object == null) {
            return "";
        }
        return object.toString();
    }
}
