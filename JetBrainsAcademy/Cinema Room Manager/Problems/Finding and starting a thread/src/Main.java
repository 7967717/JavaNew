class ThreadProcessor {
    public static void findAndStartThread(Thread... threads) throws InterruptedException {
        // implement this method
        Thread my = new Thread();
        for (Thread thread : threads) {
            if(thread.getState().equals(Thread.State.NEW)) {
                my = thread;
                my.start();
            }
        }
        my.join();
    }
}