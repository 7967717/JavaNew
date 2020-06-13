package io.rr.algorithms.codility.iterations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author roman on 9/30/17.
 */

//100%
public class BinaryGap {
    public static void main(String[] args) {
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(9));
        System.out.println(solution(15));
        System.out.println(solution(20));
        System.out.println(solution(529));
        System.out.println(solution(1041));
        System.out.println(solution(1234));
        System.out.println(solution(12345));
        System.out.println(solution(123456));
    }

    private static int solution(int n) {
        char[] chars = Integer.toBinaryString(n).toCharArray();
        List<Integer> list = new ArrayList<>();
        int acc = 0;
        for (char aChar : chars) {
            if (aChar == '0') acc++;
            else {
                list.add(acc);
                acc = 0;
            }
        }
        return Collections.max(list);
    };
}
