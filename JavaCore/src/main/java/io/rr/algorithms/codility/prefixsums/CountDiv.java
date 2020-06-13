package io.rr.algorithms.codility.prefixsums;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CountDiv {
    public static void main(String[] args) {
        Date today = new Date();
        System.out.println(today);
    }

    public int solution(int A, int B, int K) {
        Set<Integer> done = new HashSet<>();
        for (int i = A; i <= B; i++) {
            if(i % K == 0){
                done.add(i);
            }
        }
        return done.size();
    }

    static public void congrats() {
        Date today = new Date();
        if (today.getMonth() == 1 && today.getDay() == 1)
            System.out.println("Happy New Year!");
    }
}
