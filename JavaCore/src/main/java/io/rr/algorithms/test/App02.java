package io.rr.algorithms.test;

import java.math.BigInteger;
import java.util.Arrays;

public class App02 {
    public static void main(String[] args) {

        System.out.println((fib(50)));
        System.out.println((fib1(50)));
    }

    private static int fib (int i) {
        int arr[] =  new int[i + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int j = 2; j <= i; j++) {
            arr[j] = arr[j - 1] + arr[j - 2];
        }
        return arr[i];

    }

    private static BigInteger fib1 (int i) {
        if (i <= 1) return BigInteger.valueOf(i);


        BigInteger [] arr = new BigInteger[i + 1];
        arr[0] = BigInteger.ZERO;
        arr[1] = BigInteger.ONE;

        for (int j = 2; j <= i; j++) {
            arr[j] = arr[j - 1].add(arr[j - 2]);
        }

        return arr[i];
    }
}
