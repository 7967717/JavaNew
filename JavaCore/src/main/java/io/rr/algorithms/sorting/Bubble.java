package io.rr.algorithms.sorting;

import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        int[] array1 = new int[]{9, 4, 5, 1, 5, 8, 3, 6, 7, 9, 3, 0, 2, 6, 4, 8, 1, 7, 2, 0};
        System.out.println(array1.length);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(sort(array1)));
    }

    private static int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if(array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
