package com.wwy.lambda;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test3 {
    public static void main(String[] args) {
        Double[] arrs = new Double[]{1.1, 2.3, 4.0, 6.0};
        Stream<Double> stream = Arrays.stream(arrs);
        DoubleSummaryStatistics collect = stream.collect(Collectors.summarizingDouble(a -> a));
        System.out.println(collect);

        System.exit(1);


        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
        System.exit(1);

        Stream.iterate(new int[]{0, 1},
                t -> new int[]{t[1], t[0] + t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));

        System.exit(1);

        long uniqueWords = 0;
        try (Stream<String> lines =
                     Files.lines(Paths.get("D:\\workspace\\demo\\service\\service.iml"), Charset.defaultCharset())) {
//            lines.forEach(System.out::println);
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
            System.out.println(uniqueWords);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.exit(1);


        Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a ->
                                IntStream.rangeClosed(a, 100)
                                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                        .mapToObj(b ->
                                                new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                        );
        pythagoreanTriples.forEach(t ->
                System.out.println(t[0] + ", " + t[1] + ", " + t[2]));


    }
}
