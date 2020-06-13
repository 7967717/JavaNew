package io.rr.javapuzzlers._10advancedpuzzlers.puzzle87;

public class Transitive {
    public static void main(String[] args) throws Exception {
        /*
         * If you can come up with a set of primitive types and values
         * that causes this program to print "true true false", then
         * you have proven that the == operator is not transitive.
         */
        long x = Long.MAX_VALUE;
        double y = (double) Long.MAX_VALUE;
        long z = Long.MAX_VALUE - 1;

        System.out.print ((x == y) + " "); // Imprecise!
        System.out.print ((y == z) + " "); // Imprecise!
        System.out.println(x == z);        // Precise
    }
}
