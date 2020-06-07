package io.rr.algorithms.strings;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateCharactersString {
    public static void main(String[] args) {
        System.out.println(check("Collectors"));
        System.out.println(check("stream"));
    }

    private static Map<String, Long> check(String str) {
        Map<String, Long> map = str.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.toMap(Function.identity(), x -> 1L, (oldValue, newValue) -> oldValue + newValue));
        System.out.println(map);
        Map<String, Long> res = map.entrySet().stream()
                .filter(e -> (e.getValue() > 1))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return res;
    }
}
