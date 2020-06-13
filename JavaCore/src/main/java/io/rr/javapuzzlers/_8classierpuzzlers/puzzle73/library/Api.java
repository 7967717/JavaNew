package io.rr.javapuzzlers._8classierpuzzlers.puzzle73.library;

/**
 * This class may contain any desired code.  It must contain a commented-out
 * private declaration that causes the client (client.Client) to fail
 * to compile when uncommented. No prohibition is placed on what classes
 * or interfaces Api may extend or implement.
 */
public final class Api extends ApiBase {
//     private static final int ANSWER = 6 * 9;

//     private static class String {}
    public static String newString() {
        return new String();
    }

}

class ApiBase {
    public static final int ANSWER = 42;
}