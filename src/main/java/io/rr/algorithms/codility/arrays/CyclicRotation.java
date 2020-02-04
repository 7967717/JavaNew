package io.rr.algorithms.codility.arrays;

import java.util.Arrays;

/**
 * @author roman on 9/30/17.
 */

//100%
public class CyclicRotation {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{3, 8, 9, 7, 6}, 1)));
        System.out.println(Arrays.toString(solution(new int[]{3, 8, 9, 7, 6}, 3)));
    }

    private static int[] solution(int[] array, int n) {
        int arrayLength = array.length;
        int[] sol = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            sol[(i + n) % arrayLength] = array[i];
        }

        return sol;
    }
}
