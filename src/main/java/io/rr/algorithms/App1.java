package io.rr.algorithms;

import java.util.*;

/**
 * @author roman on 7/31/17.
 */
public class App1 {

    public static void main(String[] args) {
        Set<List<Integer>> set = new HashSet();

        permute(Arrays.asList(1,0,0), 0, set);
        System.out.println(set.size());
    }

    static void permute(List<Integer> arr, int k, Set<List<Integer>> set){
        for(int i = k; i < arr.size(); i++){
            Collections.swap(arr, i, k);
            permute(arr, k+1, set);
            Collections.swap(arr, k, i);
        }
        if (k == arr.size() -1){
            set.add(arr);
        }
    }
}
