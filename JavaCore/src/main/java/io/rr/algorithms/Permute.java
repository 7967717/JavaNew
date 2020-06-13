package io.rr.algorithms;

import java.util.*;

/**
 * @author roman on 7/31/17.
 */
public class Permute {

    public static void main(String[] args) {
        Set<LinkedList<Integer>> set = new HashSet<>();

//        permute(Arrays.asList(1, 0, 0), 0, set);
        permute(new LinkedList<>(Arrays.asList(2, 3, 1)), 0, set);
        System.out.println(set);
        System.out.println(set.size());
    }

    static void permute(LinkedList<Integer> arr, int k, Set<LinkedList<Integer>> set) {
        for (int i = k; i < arr.size(); i++) {
            Collections.swap(arr, i, k);
            permute(arr, k + 1, set);
            Collections.swap(arr, k, i);
        }
        if (k == arr.size() - 1) {
            System.out.println("1" + arr);
            set.add(arr);
            System.out.println("2" + set);
        }
    }
}
