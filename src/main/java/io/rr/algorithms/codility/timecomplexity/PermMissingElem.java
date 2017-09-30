package io.rr.algorithms.codility.timecomplexity;

/**
 * @author roman on 9/30/17.
 */

//100%
public class PermMissingElem {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{}));
        System.out.println(solution(new int[]{1}));
        System.out.println(solution(new int[]{2}));
        System.out.println(solution(new int[]{2, 3, 5, 4}));
        System.out.println(solution(new int[]{2, 3, 1, 4}));
        System.out.println(solution(new int[]{2, 3, 1, 5}));
    }

    private static int solution(int[] arr) {
        int length = arr.length;
        long sum = (length + 1L) * (length + 2) / 2;
        for (int element : arr) {
            sum -= element;
        }
        return (int) sum;
    }
}
