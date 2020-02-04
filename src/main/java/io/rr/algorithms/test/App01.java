package io.rr.algorithms.test;

import java.util.Arrays;

public class App01 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(fib(10)));
    }

    private static int[] fib(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int j = 2; j <= n; j++) {
            arr[j] = arr[j - 1] + arr[j - 2];
        }
        return arr;
    }
}
