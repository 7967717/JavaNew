package io.rr.java8.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

public class App01 {
    private static String[] read(String path) throws IOException {
        Map<String, Long> collect = Files.lines(Paths.get(path))
                .map(line -> line.split("\\s+"))
                .flatMap(Arrays::stream)
                .map(word -> word.replaceAll("[^a-zA-Z]", "").trim())
                .filter(word -> !word.isEmpty())
//                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
                .collect(Collectors.toMap(Function.identity(), x -> 1L, (oldValue, newValue) -> oldValue + newValue));
        System.out.println(collect);
        return collect.keySet().toArray(new String[0]);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(read("src/main/resources/task3.txt")));
        Files.walk(Paths.get("src/main/resources")).forEach(System.out::println);
        System.out.println(Files.walk(Paths.get("src/main/resources")).count());
    }
}
