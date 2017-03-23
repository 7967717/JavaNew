package io.rr.javapuzzlers._4loopypuzzlers.puzzle35;

public class Clock {
    private static final int MS_PER_HOUR   = 60 * 60 * 1000;
    private static final int MS_PER_MINUTE = 60 * 1000;

    public static void main(String[] args) {

        int minutes = 0;
        for (int ms = 0; ms < 60*60*1000; ms++)
            if (ms % (60*1000) == 0)
                minutes++;
        System.out.println(minutes);
    }
}
