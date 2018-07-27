package io.rr.algorithms.princeton;

public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(sum(new int[]{30, -40, -20, -10, 40, 0, 10, 5}));

    }

    private static int sum(int[] a) {
        int l = a.length;
        int s = 0;
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                for (int k = j + 1; k < l; k++) {
                    if ((a[i] + a[j] + a[k]) == 0) s++;
                }
            }
        }
        return s;
    }
}
