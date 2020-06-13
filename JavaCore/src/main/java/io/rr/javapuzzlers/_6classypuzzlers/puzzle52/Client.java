package io.rr.javapuzzlers._6classypuzzlers.puzzle52;

class Cache {
    private static boolean initialized = false;
    static {
        initializeIfNecessary();
    }

    private static int sum;
    public static int getSum() {
        initializeIfNecessary();
        return sum;
    }

//    wrong
//    private static boolean initialized = false;
    private static synchronized void initializeIfNecessary() {
        if (!initialized) {
            for (int i = 0; i < 100; i++)
                sum += i;
            initialized = true;
        }
    }
}

public class Client {
    public static void main(String[] args) {
        System.out.println(Cache.getSum()); 
    } 
}
