package io.rr.javapuzzlers._4loopypuzzlers.puzzle26;

public class InTheLoop {
    public static final int END = Integer.MAX_VALUE;
    public static final int START = END - 100;

    public static void main(String[] args) {
        int count = 0;
//        for (int i = START; i <= END; i++)
        for (long i = START; i <= END; i++)
            count++;
        System.out.println(count);
    }
}
