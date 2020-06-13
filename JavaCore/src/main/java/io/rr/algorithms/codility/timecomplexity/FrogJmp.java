package io.rr.algorithms.codility.timecomplexity;

/**
 * @author roman on 9/30/17.
 */
public class FrogJmp {
    public static void main(String[] args) {
        System.out.println(solution(10, 85, 30));
    }

    private static int solution(int x, int y, int d) {
            int y1 = y - x;
            return y1 / d + ((y1 % d == 0) ? 0 : 1);
        }

}
