package io.rr.javapuzzlers._4loopypuzzlers.puzzle33;

public class LooperMeetsWolfman {
    public static void main(String[] args) {
        // Place your declaration for i here

        int i = Integer.MIN_VALUE;

        while (i != 0 && i == -i) {
            System.out.println(i);
        }
    }
}
