package io.rr.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class App01 {
    public static void main(String[] args) {
        String[] strarr = {"abc", "defg", "vwxyz"};

        System.out.println(Arrays.stream(strarr).map(String::length).collect(Collectors.toList()));
        System.out.println(Arrays.toString(Arrays.stream(strarr).mapToInt(String::length).toArray()));
        System.out.println(Arrays.stream(strarr).map(String::length).max(Comparator.comparingInt(a -> - a)));
        System.out.println(Arrays.stream(strarr).mapToInt(String::length).max());

        System.out.println(Arrays.stream(strarr).reduce(0, (l, s) -> l + s.length(), (s1, s2) -> s1 + s2));


        Integer[] arr = new Integer[]{100, 24, 13, 44, 114, 200, 40, 112};
        System.out.println(Arrays.stream(arr)
                .mapToInt(a -> a * a)
                .filter(b -> b > 10000)
                .average());
        System.out.println();
        System.out.println(Arrays.asList(1,2,3));

    }
}
