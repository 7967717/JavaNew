package io.rr.javapuzzlers._2expressivepuzzlers.puzzle1;

public class Oddity {
    public static boolean isOdd(int i) {
        return i % 2 != 0;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + "is Odd - " + isOdd(i));
        }

        for (int i = 0; i > -10; i--) {
            System.out.println(i + " is Odd - " + isOdd(i));
        }

    }
}
