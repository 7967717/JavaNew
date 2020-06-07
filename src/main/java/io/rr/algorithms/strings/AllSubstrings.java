package io.rr.algorithms.strings;

import java.util.HashSet;
import java.util.Set;

public class AllSubstrings {
    public static void main(String[] args) {
        System.out.println(find("allo"));
    }

    private static Set<String> find(String str) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                set.add(str.substring(i, j));
            }
        }
        return set;
    }
}
