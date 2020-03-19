package com.wwy.test;

public class Test6 {

    public static void main(String[] args) throws ClassNotFoundException {
        String x = "123";

        Class clazz = Class.forName("java.lang.Integer");
        Integer x2 = get(Integer.class, x);
        System.out.println(x2);
    }

    public static <T> T get(Class<T> clz, Object o) {
        if (clz.isInstance(o)) {
            return clz.cast(o);
        }
        return null;
    }
}
