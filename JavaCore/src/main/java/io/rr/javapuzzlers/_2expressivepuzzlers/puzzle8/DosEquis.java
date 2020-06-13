package io.rr.javapuzzlers._2expressivepuzzlers.puzzle8;

public class DosEquis {
    public static void main(String[] args) {
        char x = 'X';
        int i = 0;
        System.out.println(true  ? x : 0); /*==*/ System.out.println(x);
        System.out.println(false ? i : x); /*!=*/ System.out.println(x);
        System.out.println(false ? 0 : x); /*==*/ System.out.println(x);
    }
}
