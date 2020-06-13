package io.rr.algorithms.codility.countingelements;

import java.util.HashSet;
import java.util.Set;

public class PermCheck {
    public int solution(int[] A) {
        HashSet<Integer> done = new HashSet<>();
        Set<Integer> opt = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            done.add(A[i]);
            opt.add(i + 1);
        }

        for (int elem : opt) {
            if (!done.contains(elem)) {
                return 0;
            }
        }
        return 1;
    }
}

