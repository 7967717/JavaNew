package io.rr.algorithms.codility.iterations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author roman on 9/30/17.
 */
public class BinaryGap {
    public static void main(String[] args) {
        System.out.println(solution(9));
        System.out.println(solution(15));
        System.out.println(solution(529));
    }

    public static int solution(int n) {
        char[] chars = Integer.toBinaryString(n).toCharArray();
        List<Integer> list = new ArrayList<>();
        int acc = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '0') chars[i] = '-';
            else break;
        }
        for (int i = chars.length - 1; i < 1; i--) {
            if(chars[i] == '0') chars[i] = '-';
            else break;
        }
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
