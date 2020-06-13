package io.rr.other;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author roman on 3/10/17.
 */
public class Test0 {
    private int r;
    private int c;
    private int r0;
    private int c0;
    private int [][] garden;
    private int sum;

    public Test0(int r, int c, int[][] garden) {
        this.r = r;
        this.c = c;
        this.r0 = 0;
        this.c0 = --c;
        this.garden = garden;
    }

//    private int [][] fill(Map<Integer, List<Integer>> map) {
//        int [][] temp = new int[h][v];
//        for (Map.Entry entry : map.entrySet()) {
//            for(Object val : (List) entry.getValue()) {
//
//            }
//        }
//    }

    void print() {
        int rowSize = garden[0].length;
        int columnSize = garden.length;
        System.out.println(Arrays.deepToString(garden));
    }

    int go(){
        sum = sum + garden[r0][c0];
        while (r0 != r - 1 || c0 != 0) {
            //go lower
            if((r0 == r - 1) || (garden[r0][c0 - 1] > garden[r0 + 1][c0])) {
                sum = sum + garden[r0][c0 - 1];
                c0 = --c0;
            //go right
            } else {
                sum = sum + garden[r0 + 1][c0];
                r0 = ++r0;
            }
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        int [][] temp = new int[][]{
            {1,2,3},
            {1,2,3},
            {1,2,3}
        };

        Test0 test = new Test0(3, 3, temp);
        test.print();
        int res = test.go();
        System.out.println(res);
    }
}
