package io.rr.algorithms.codility.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxProductOfThree {
    public static void main(String[] args) {
        System.out.println(solution1(new int[]{-3, 1, 2, -2, 5, 6}));
        List<Integer> list = IntStream.range(1, 10).boxed().sorted((o1, o2) -> o2 - o1).collect(Collectors.toList());
        System.out.println(list);
    }

    public static int solution1(int[] A) {
        ArrayList<Integer> ints = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            ints.add(A[i]);
        }

        Collections.sort(ints);
        int size = ints.size();
        int max1 = ints.get(0) * ints.get(1) * ints.get(2);
        int max2 = ints.get(size - 1) * ints.get(size - 2) * ints.get(size - 3);
        int max3 = ints.get(0) * ints.get(size - 1) * ints.get(size - 2);
        int max4 = ints.get(0) * ints.get(1) * ints.get(size - 1);

        return Math.max(Math.max(max1, max2), Math.max(max3, max4));
    }

    public static int solution2(int[] A) {
        int a = 0, b = 0, c = 0;

        for (int aA : A) {
            if (aA > a) a = aA;
        }
        for (int aA : A) {
            if (aA > b && aA < a) b = aA;
        }
        for (int aA : A) {
            if (aA > c && aA < b) {
                c = aA;
            }
        }
        return a * b * c;
    }

}
