public class Main {

    public static void main(String[] args) {

        // create threads and start them using the class RunnableWorker
        new Thread(new RunnableWorker(), "worker-1").start();
        new Thread(new RunnableWorker(), "worker-2").start();
        new Thread(new RunnableWorker(), "worker-3").start();

    }
}

// Don't change the code below       
class RunnableWorker implements Runnable {

    @Override
    public void run() {
        final String name = Thread.currentThread().getName();

        if (name.startsWith("worker-")) {
            System.out.println("too hard calculations...");
        } else {
            return;
        }
    }
}