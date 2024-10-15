package io.rr.tests.luxoft;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 2, 3, 3, 3, 4, 5, 5);

        Map<Integer, List<Integer>> collect = integers.stream().collect(Collectors.groupingBy(Function.identity()));
        System.out.println(collect);

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : integers) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        System.out.println(map);
    }
}
