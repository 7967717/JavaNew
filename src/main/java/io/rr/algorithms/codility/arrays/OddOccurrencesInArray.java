package io.rr.algorithms.codility.arrays;

/**
 * @author roman on 9/30/17.
 */

//100%
public class OddOccurrencesInArray {
    public static void main(String[] args) {
        System.out.println(solution(new int []{9, 3, 9, 3, 9, 7, 9}));
    }

    private static int solution(int[] arr) {
        int unpaired = 0;
        for (int number : arr) {
            unpaired ^= number;
        }
        return unpaired;
    }
}
