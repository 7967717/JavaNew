package io.rr.algorithms.codility.countingelements;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {
    public static void main(String[] args) {
        int[] A = new int[8];
        A[0] = 1;
        A[1] = 3;
        A[2] = 1;
        A[3] = 4;
        A[4] = 2;
        A[5] = 3;
        A[6] = 5;
        A[7] = 4;
//        System.out.println(solution(5, A));
//        System.out.println(solution(3, new int[]{1, 3, 1, 3, 2, 1, 3}));
        gcd(8, 18);

    }

    public static int gcd(int x, int y) {
        for (int r; (r = x % y) != 0; x = y, y = r) {
            System.out.println(r + " " + x + " " + y + " ");
        }
        System.out.println(y);
        return y;
    }

    public static int solution(int X, int[] A) {
        Set<Integer> expected = new HashSet<>();

        for (int i = 1; i <= X; i++) {
            expected.add(i);
        }
        System.out.println(expected);

        Set<Integer> current = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            current.add(A[i]);
            if (current.size() < expected.size()) continue;

            if (current.containsAll(expected)) return i;
        }
        return -1;
    }
}

