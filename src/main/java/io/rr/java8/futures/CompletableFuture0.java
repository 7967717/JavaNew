package io.rr.java8.futures;

import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author rrudenko on 02.10.2017.
 */
public class CompletableFuture0 implements Supplier<Integer> {
    private Integer value;

    public CompletableFuture0(Integer value) {
        System.out.println(Thread.currentThread() + " initial value - " + value);
        this.value = value;
    }

    @Override
    public Integer get() {
        try {
            Thread.sleep(1000);
            value++;
            System.out.println(Thread.currentThread() + " first computation - " + value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Thread.currentThread() + " start async computation");
        ExecutorService exec = Executors.newSingleThreadExecutor();
        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(new CompletableFuture0(0), exec);
        CompletableFuture<Integer> f2 = f1.thenApplyAsync(i -> {
            i++;
            System.out.println(Thread.currentThread() + " computation after f1 - " + i);
            return i;
        });
        f2.thenApplyAsync(i -> {
            i++;
            System.out.println(Thread.currentThread() + " computation after f2 - " + i);
            return i;
        });
        System.out.println(f1.getNow(-1));
        System.out.println(f2.getNow(-1));
        System.out.println(f1.isDone());
        System.out.println(f2.isDone());
        System.out.println(Thread.currentThread() + " going on in main");
        Thread.sleep(1000);
        exec.shutdown();
    }
}
