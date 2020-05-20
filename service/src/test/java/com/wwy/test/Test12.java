package com.wwy.test;

import com.google.common.collect.Lists;
import com.wwy.api.FunctionService;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;

public class Test12 {
    public static void main(String[] args) {

        Predicate<String> tPredicate = a -> a != null;
        boolean aNull = tPredicate.test("null");

        IntBinaryOperator functionService = (a, b) -> a + b;
        int i = functionService.applyAsInt(2, 3);
        System.out.println(i);
        System.exit(1);


        process((a, b) -> a + b, 2, 3);

        Predicate<String> nonEmptyStringPredicate = (String s) -> s != null && !s.isEmpty();
        List<String> nonEmpty = filter(Lists.newArrayList("aaa", "", null), nonEmptyStringPredicate);
        System.out.println(nonEmpty);
    }

    public static void process(FunctionService functionService, int a, int b) {
        int add = functionService.op(a, b);
        System.out.println(add);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T s : list) {
            if (p.test(s)) {
                results.add(s);
            }
        }
        return results;
    }
}
