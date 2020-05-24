package io.rr.algorithms.codility.countingelements;

import java.util.Set;
import java.util.TreeSet;

public class MissingInteger {
    public int solution(int[] A) {
        Set<Integer> done = new TreeSet<>();
        TreeSet<Integer> perf = new TreeSet<>();

        for (int i=0; i<A.length; i++) {
            done.add(A[i]);
            perf.add(i+1);
        }

        for (int elem : perf) {
            if (!done.contains(elem)) return elem;
        }

        if(done.size() == perf.size()) return perf.last() + 1;

        return 1;
    }
}
