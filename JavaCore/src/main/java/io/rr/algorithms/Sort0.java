package io.rr.algorithms;

import java.util.Arrays;

/**
 * @author roman on 4/6/17.
 */
public class Sort0 {
    public static void main(String[] args) {
        int[] array1 = new int[]{9, 1, 5, 3, 2, 6, 8, 1};
        int[] array2 = new int[]{9, 1, 5, 3, 2, 6, 8, 1};
        int[] array3 = new int[]{9, 1, 5, 3, 2, 6, 8, 1};

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(sort1(array1)));
        System.out.println(Arrays.toString(sort2(array2)));
        System.out.println(Arrays.toString(sort3(array3)));
    }

    private static int[] sort1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int tmp = array[i + 1];
            if (array[i] > array[i + 1]) {
                array[i + 1] = array[i];
                array[i] = tmp;
            }
            for (int j = 1; j < array.length - 1; j++) {
                int tmp1 = array[j + 1];
                if (array[j] > array[j + 1]) {
                    array[j + 1] = array[j];
                    array[j] = tmp1;
                }
            }
        }
        return array;
    }

    private static int[] sort2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int tmp = array[i];
                if (tmp > array[j]) {
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        return array;
    }

    private static int[] sort3(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if(array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }
}
