package com.wwy.test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class Test15 {
    public static void main(String[] args) {
        String str = "BiConsumer\n" +
                "BiFunction\n" +
                "BinaryOperator\n" +
                "BiPredicate\n" +
                "BooleanSupplier\n" +
                "Consumer\n" +
                "DoubleBinaryOperator\n" +
                "DoubleConsumer\n" +
                "DoubleFunction\n" +
                "DoublePredicate\n" +
                "DoubleSupplier\n" +
                "DoubleToIntFunction\n" +
                "DoubleToLongFunction\n" +
                "DoubleUnaryOperator\n" +
                "Function\n" +
                "IntBinaryOperator\n" +
                "IntConsumer\n" +
                "IntFunction\n" +
                "IntPredicate\n" +
                "IntSupplier\n" +
                "IntToDoubleFunction\n" +
                "IntToLongFunction\n" +
                "IntUnaryOperator\n" +
                "LongBinaryOperator\n" +
                "LongConsumer\n" +
                "LongFunction\n" +
                "LongPredicate\n" +
                "LongSupplier\n" +
                "LongToDoubleFunction\n" +
                "LongToIntFunction\n" +
                "LongUnaryOperator\n" +
                "ObjDoubleConsumer\n" +
                "ObjIntConsumer\n" +
                "ObjLongConsumer\n" +
                "Predicate\n" +
                "Supplier\n" +
                "ToDoubleBiFunction\n" +
                "ToDoubleFunction\n" +
                "ToIntBiFunction\n" +
                "ToIntFunction\n" +
                "ToLongBiFunction\n" +
                "ToLongFunction\n" +
                "UnaryOperator";

        Supplier<Integer> s= ()->new Integer(1);
        int o = s.get();

        String[] split = str.split("\n");
        List<String> strings = Arrays.asList(split);
        strings.stream().forEach(a -> {
            if (a.endsWith("Function")) {
                String temp = "";
                try {
                    temp = temp + a;
                    Class classz = Class.forName("java.util.function." + a);
                    Method[] declaredMethods = classz.getDeclaredMethods();
                    for (Method declaredMethod : declaredMethods) {
                        boolean defaultMethod = isDefaultMethod(declaredMethod);
                        boolean privateMethod = isPrivateMethod(declaredMethod);
                        boolean staticMethod = isStaticMethod(declaredMethod);
                        if (!defaultMethod && !privateMethod && !staticMethod) {
//                        System.out.println(declaredMethod.getGenericParameterTypes());
                            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
                            temp = temp + "\t";
                            for (Class<?> parameterType : parameterTypes) {
                                temp = temp + "\t" + parameterType.getName();
                            }
                            System.out.println(temp + ":" + declaredMethod.getGenericReturnType().getTypeName());
                        }
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
//        System.out.println(strings);
    }

    private static boolean isDefaultMethod(Method method) {
        return ((method.getModifiers()
                & (Modifier.ABSTRACT | Modifier.PUBLIC | Modifier.STATIC)) == Modifier.PUBLIC)
                && method.getDeclaringClass().isInterface();
    }

    private static boolean isPrivateMethod(Method method) {
        return Modifier.isPrivate(method.getModifiers());
    }

    private static boolean isStaticMethod(Method method) {
        return Modifier.isStatic(method.getModifiers());
    }


}
