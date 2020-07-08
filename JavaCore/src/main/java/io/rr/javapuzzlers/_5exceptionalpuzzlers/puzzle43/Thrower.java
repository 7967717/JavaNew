package io.rr.javapuzzlers._5exceptionalpuzzlers.puzzle43;

public class Thrower {

    private static Throwable t;
    private Thrower() throws Throwable {
        throw t;
    }

    public static void main(String[] args) {
        sneakyThrow(new Exception("This is a checked exception"));
    }

    /*
     * Provide a body for this method to make it throw the specified exception.
     * You must not use any deprecated methods.
     */
    public static void sneakyThrow(Throwable t) {
        Thrower.t = t;
        try {
            Thrower.class.newInstance();
        } catch (InstantiationException e) {
            throw new IllegalArgumentException();
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException();
        } finally {
            Thrower.t = null; // Avoid memory leak
        }
    }
}
