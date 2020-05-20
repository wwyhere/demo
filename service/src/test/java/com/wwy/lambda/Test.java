package com.wwy.lambda;

import com.wwy.lambda.model.CaloricLevel;
import com.wwy.lambda.model.Dish;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class Test {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

//        Optional<Dish> collect = menu.stream().collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories)));
//        Dish dish = collect.get();
//        System.out.println(dish);
//
//
//        Double collect1 = menu.stream().collect(Collectors.averagingDouble(Dish::getCalories));
//        System.out.println(collect1);

        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
                menu.stream().collect(
                        groupingBy(Dish::getType,
                                groupingBy(dish -> {
                                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                    else return CaloricLevel.FAT;
                                })
                        )
                );
        System.out.println(dishesByTypeCaloricLevel);

        Map<Dish.Type, Dish> mostCaloricByType =
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                collectingAndThen(
                                        maxBy(comparingInt(Dish::getCalories)),
                                        Optional::get)));

        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType =
                menu.stream().collect(
                        groupingBy(Dish::getType, mapping(
                                dish -> {
                                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                    else return CaloricLevel.FAT;
                                },
                                toSet())));

        Map<Boolean, List<Dish>> collect = menu.stream().collect(groupingBy(Dish::isVegetarian));
        System.out.println(collect);

        Map<Boolean, List<Dish>> partitionedMenu =
                menu.stream().collect(partitioningBy(Dish::isVegetarian));
        System.out.println(partitionedMenu);

//        Arrays.stream(arrs).collect(Collectors.compu);
    }
}
