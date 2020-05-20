package com.wwy.lambda;

public class Test6 {
    public static void main(String[] args) {
        int a = 10;
        Runnable r2 = new Runnable() {
            public void run() {
                System.out.println(this.getClass().getName());
                System.out.println(a);
            }
        };
        r2.run();
    }
}
