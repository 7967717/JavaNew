package io.rr.javapuzzlers._2expressivepuzzlers.puzzle10;

public class Tweedledee {
    public static void main(String[] args) {
        // Put your declarations for x and i here
        Object x = "0";
        String i = "1";

        x = x + i;  // Must be LEGAL
        x += i;     // Must be ILLEGAL

        System.out.println(x);
    }
}
