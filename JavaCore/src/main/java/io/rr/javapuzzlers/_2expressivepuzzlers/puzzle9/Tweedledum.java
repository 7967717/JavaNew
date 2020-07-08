package io.rr.javapuzzlers._2expressivepuzzlers.puzzle9;

public class Tweedledum {
    public static void main(String[] args) {
        // Put your declarations for x and i here
        short x = 0;
        int i = 123456;

        x += i;     // Must be LEGAL

//        x = x + i;  // Must be ILLEGAL

        System.out.println(x);
    }
}
