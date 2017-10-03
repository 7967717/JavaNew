package io.rr.java8.futures;

import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author rrudenko on 02.10.2017.
 */
public class CompletableFuture0 implements Supplier<Integer> {
    @Override
    public Integer get() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        CompletableFuture<Integer> f = CompletableFuture.supplyAsync(new CompletableFuture0(), exec);
        System.out.println(f.isDone());
        CompletableFuture<Integer> f2 = f.thenApply(i -> i + 1);
        System.out.println(f2.isDone());
        System.out.println(f2.get());
        System.out.println(f.isDone());
        System.out.println(f2.isDone());
        exec.shutdown();
    }
}
