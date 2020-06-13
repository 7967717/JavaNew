package io.rr.javapuzzlers._2expressivepuzzlers.puzzle5;

public class JoyOfHex {
    public static void main(String[] args) {
        System.out.println(
            Long.toHexString(0x100000000L + 0xcafebabeL));

        System.out.println(1L + "cafebabe");
    }
}
