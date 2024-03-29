package io.rr.javapuzzlers._10advancedpuzzlers.puzzle87;

public class Reflexive {
    public static void main(String[] args) throws Exception {
        /*
         * If you can come up with a primitive type and value
         * that causes this program to print "false", then
         * you have proven that the == operator is not reflexive.
         */
        double x = Double.NaN;
        double y = (double) 1/3;
        double z = 1/3;


        System.out.println(x == x);
        System.out.println(y == z);
        System.out.println(y);
        System.out.println(z);
    }
}
