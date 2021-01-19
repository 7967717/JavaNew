class CounterThread extends Thread {

    @Override
    public void run() {
        long counter = 0;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (true) {
            counter++;
            if(isInterrupted()){
                System.out.println("It was interrupted");
                break;
            }
        }
    }
}