package io.rr.tests.test;

/**
 * @author rrudenko on 13.06.2017.
 */
public class JustTest {
    public static void main(String[] args) {
        String s = "2";
        String r = "r";

        switch (s) {
            case "0" :
            case "1" :
            case "2" : r = "2"; break;
            case "3" : r = "3"; break;
        }

        System.out.println(r);

    }
}
