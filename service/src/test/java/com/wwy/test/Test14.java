package com.wwy.test;

import com.google.common.collect.Maps;
import org.assertj.core.util.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test14 {
    public static void main(String[] args) {

        Function<String, String> function = (a) -> "";

        Consumer<String> consumer = (a) -> {
            System.out.println(a);
        };

        Predicate<String> predicate = (a) -> a == null;

        Supplier<String> supplier = () -> "";

        List<String> str = Arrays.asList("a", "b", "A", "B");
//        str.sort((s1,s2)->s1.compareTo(s2));
//        str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));

        str.sort(String::compareToIgnoreCase);
        str.stream().forEach(System.out::println);

        Function<String, Integer> stringToInteger = Integer::parseInt;
        BiPredicate<List<String>, String> contains = List::contains;

        Supplier<MeaningOfThis> meaningOfThisSupplier = MeaningOfThis::new;

        MeaningOfThis meaningOfThis = meaningOfThisSupplier.get();
        MeaningOfThis meaningOfThis1 = meaningOfThisSupplier.get();

        System.out.println(meaningOfThis.equals(meaningOfThis1));

        Map<String, Function<Integer, ModelA>> map = Maps.newHashMap();

        map.put("aaa", ModelA::new);

        ModelA aaa = map.get("aaa").apply(1);
        System.out.println(aaa.getAge());

        System.out.println(predicate.test("aaa"));
        Predicate<String> negate = predicate.negate();
        System.out.println(negate.test("aaa"));


        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.compose(g);
        int result = h.apply(5);
        System.out.println(result);

        List<String> list1 = Arrays.asList("Hello", "World");

        List<String> collect = list1.stream().map(a -> Arrays.asList(a.split(""))).flatMap(List::stream).distinct().collect(Collectors.toList());
        System.out.println(collect);

        List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5);
        //[1, 4, 9, 16, 25]
        List<Integer> collect1 = intList.stream().map(a -> a * a).collect(Collectors.toList());
        System.out.println(collect1);

        List<Integer> intList1 = Lists.newArrayList(1, 2, 3);
        List<Integer> intList2 = Lists.newArrayList(3, 4);
        Stream<int[]> stream = intList1.stream().flatMap(a -> (
                intList2.stream().map(b -> new int[]{a, b})
        ));

        Integer reduce = intList1.stream().reduce(0, Integer::sum);
        System.out.println(reduce);
    }
}
