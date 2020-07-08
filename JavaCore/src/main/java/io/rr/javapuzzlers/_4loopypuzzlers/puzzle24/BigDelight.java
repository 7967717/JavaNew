package io.rr.javapuzzlers._4loopypuzzlers.puzzle24;

class BigDelight {
    public static void main(String[] args) {
        for (byte b = Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++) {
            if (b == (byte) 0x90)
                System.out.print("Joy!");
        }
    }
}
