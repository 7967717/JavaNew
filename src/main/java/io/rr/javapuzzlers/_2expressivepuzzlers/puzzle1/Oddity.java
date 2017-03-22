package io.rr.javapuzzlers._2expressivepuzzlers.puzzle1;

public class Oddity {
    public static boolean isOdd(int i) {
        return i % 2 == 1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(isOdd(i));
        }

        System.out.println(isOdd(Integer.MAX_VALUE));
        System.out.println(isOdd(Integer.MIN_VALUE));
    }
}
