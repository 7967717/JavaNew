package io.rr.algorithms;

/**
 * @author roman on 7/27/17.
 */
public class Equilibrium {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{-1, 3, -4, 5, 1, -6, 2, 1}));
    }

    public static int solution(int[] a) {
        int ind = -1;
        int rSum = 0, lSum = 0;

        for (int index = 0; index < a.length; index++) {
            rSum += a[index];
        }

        for (int index = 0; index < a.length; index++) {
            lSum += (index == 0) ? 0 : a[index - 1];
            rSum -= a[index];
            if (lSum == rSum) {
                return index;
            }
        }
        return ind;
    }
}
