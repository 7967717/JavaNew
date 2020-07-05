package io.rr.algorithms;

import java.util.ArrayList;
import java.util.Collections;

public class GCD {
    public static void main(String[] args) {
        System.out.println(generalizedGCD(5, new int[]{2, 4, 6, 8, 10}));
        System.out.println(generalizedGCD(5, new int[]{36, 60}));
    }

    public static int generalizedGCD(int num, int[] arr) {
        ArrayList<Integer> gcds = new ArrayList<>();

        for (int i = 1; i <= arr[arr.length - 1]; i++) {
            boolean flag = true;
            for (int j : arr) {
                if (j % i != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                gcds.add(i);
            }
        }
        return gcds.size() == 0 ? 1 : Collections.max(gcds);
    }

}
