package io.rr.algorithms;

import java.util.Arrays;

/**
 * @author roman on 7/16/17.
 */
public class Reverse {
    public static void main(String[] args) {
        System.out.println(reverse("Hello"));
        System.out.println(Arrays.toString(reverseArr(new int[]{1, 2, 3, 4, 5})));
    }

    private static String reverse(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        StringBuilder res = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) res.append(s.charAt(i));
        return res.toString();
    }

    private static int[] reverseArr(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        return arr;
    }
}
