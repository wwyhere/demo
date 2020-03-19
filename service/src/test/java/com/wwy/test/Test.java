package com.wwy.test;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String args[]) {
        Set<Short> s = new HashSet<Short>();
        for (Short i = 0; i < 100; i++) {
            s.add(i);
            s.remove(i - 1);
        }
        System.out.println(s.size());
    }
}
