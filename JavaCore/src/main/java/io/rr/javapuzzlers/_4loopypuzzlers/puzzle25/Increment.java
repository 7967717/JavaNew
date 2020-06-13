package io.rr.javapuzzlers._4loopypuzzlers.puzzle25;

public class Increment {
    public static void main(String[] args) {
        int j = 0;
        for (int i = 0; i < 100; i++)
//            wrong
//            j = j++;
            j++;
        System.out.println(j);
    }
}
