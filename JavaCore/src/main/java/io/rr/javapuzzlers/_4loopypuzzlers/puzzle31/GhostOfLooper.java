package io.rr.javapuzzlers._4loopypuzzlers.puzzle31;

public class GhostOfLooper {
    public static void main(String[] args) {
        // Place your declaration for i here

        short i = -1;

        while (i != 0)
            System.out.println(i);
            i >>>= 1;
    }
}
