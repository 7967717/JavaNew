package io.rr.concurrent;

public class BadThreads {
    static String message;

    private static class CorrectorThread
            extends Thread {

        public void run() {
            try {
                sleep(2000);
            } catch (InterruptedException e) {

            }
            // Key statement 1:
            message = "Mares do eat oats.";
        }
    }

    public static void main(String args[])
            throws InterruptedException {

        CorrectorThread correctorThread = new CorrectorThread();
        correctorThread.start();
        message = "Mares do not eat oats.";
        Thread.sleep(1000);
        // Key statement 2:
        correctorThread.join();
        System.out.println(message);
        Thread.sleep(2000);
        System.out.println(message);
    }
}
