package io.rr.javapuzzlers._4loopypuzzlers.puzzle34;

public class Count {
    public static void main(String[] args) {
        final int START = 2000000000;
        int count = 0;
//        for (float f = START; f < START + 50; f++)
        for (int f = START; f < START + 50; f++)
            count++;
        System.out.println(count);
    }
}