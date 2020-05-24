package io.rr.java8.futures;

import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.Assert.assertTrue;

public class CompletableFuture1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> future1
                = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2
                = CompletableFuture.supplyAsync(CompletableFuture1::comp);
        CompletableFuture<String> future3
                = CompletableFuture.supplyAsync(() -> "World");

        ExecutorService exec = Executors.newSingleThreadExecutor();
        exec.submit(() -> {
            System.out.println("111111111");
            String s = Stream.of(future1, future2, future3)
                    .map(CompletableFuture::join)
                    .collect(Collectors.joining(" "));
            System.out.println(s);
        });

        CompletableFuture<Void> combinedFuture
                = CompletableFuture.allOf(future1, future2, future3);
        Thread.sleep(2000);
        System.out.println("22222222222");
        combinedFuture.get();
        System.out.println(combinedFuture.isDone());

        exec.shutdown();
        assertTrue(future1.isDone());
        assertTrue(future2.isDone());
        assertTrue(future3.isDone());
    }

    private static String comp() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Beautiful";
    }
}
