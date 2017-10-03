package io.rr.java8.futures;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author rrudenko on 02.10.2017.
 */
public class Future0 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(2000);
        return 1;
    }

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        Future<Integer> f = exec.submit(new Future0());

        System.out.println(f.isDone());
        System.out.println(f.get());
        System.out.println(f.isDone());
        exec.shutdown();
    }
}
