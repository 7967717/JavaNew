package io.rr.algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        System.out.println(solution(30));
    }

    private static Set<Integer> solution(int limit) {
        if (limit < 2) return new TreeSet<>();
        boolean[] arr = new boolean[limit + 1];
        Arrays.fill(arr, true);
        arr[0] = false;
        arr[1] = false;

        for (int i = 2; i * i <= limit; i++) {
            if (arr[i]) {
                for (int j = i + i; j <= limit; j += i) {
                    arr[j] = false;
                }
            }
        }
        Set<Integer> set = new TreeSet<>();
        for (int i = 2; i < arr.length; i++) {
            if (arr[i]) set.add(i);
        }
        return set;
    }
}
