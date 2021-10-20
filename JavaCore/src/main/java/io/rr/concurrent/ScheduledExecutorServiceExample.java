package io.rr.concurrent;

import static java.util.concurrent.TimeUnit.MINUTES;
import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

public class ScheduledExecutorServiceExample {

//    private static final AtomicReference<Boolean> stopTokenUpdateJob = new AtomicReference<>(false);

    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        final Runnable refresher = () -> {
//            if (!stopTokenUpdateJob.get()) {
                System.out.println("--------------------");
                System.out.println("ScheduledExecutorService");
//            }
        };
        scheduler.scheduleWithFixedDelay(refresher, 3, 3, SECONDS);

        scheduler.schedule(() -> scheduler.shutdown(), 16, SECONDS);
    }
}
