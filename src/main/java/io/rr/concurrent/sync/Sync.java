package io.rr.concurrent.sync;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author roman on 3/28/17.
 */
public class Sync {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(3);

//        IntStream.range(0, 10000)
//                .forEach(i -> executor.submit(new Incrementer()));

        IntStream.range(0, 1000)
                .forEach(i -> executor.submit(new Incrementer()));

//        ConcurrentUtils.stop(executor);

        Thread.sleep(1000);

        System.out.println(Incrementer.count);  // 9965

    }

}

class Incrementer implements Callable {

    static int count = 0;

    @Override
    public Object call() throws Exception {
//        increment();
        incrementSync();
        return count;
    }

    void increment() {
        count = count + 1;
    }

    synchronized void incrementSync() {
        count = count + 1;
    }
}