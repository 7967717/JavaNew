package io.rr.algorithms.strings;

import java.util.Optional;

public class FirstNonRepeatedChar {
    public static void main(String[] args) {
        System.out.println(find("optional"));
        System.out.println(find("algorithms"));
        System.out.println(find("algogoal"));
    }

    private static Optional<Character> find(String str) {
        for (char c : str.toCharArray()) {
            if (str.indexOf(c) == str.lastIndexOf(c)) {
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }
}
