package io.rr.concurrent.ProducerConsumer;

import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        Job job = new Job(10);
        Consumer consumer = new Consumer(job);
        Producer producer = new Producer(job);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

class Product {
    private int id;

    public Product(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                '}';
    }
}

class Job {
    private Product product;
    final int quantity;
    AtomicInteger id = new AtomicInteger(1);
    private volatile boolean empty = true;

    public Job(int quantity) {
        this.quantity = quantity;
    }

    public synchronized void produce() {
        while (!empty) {
            try {
                Thread.sleep(500);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product = new Product(id.getAndIncrement());
        System.out.println("produced " + product);
        empty = false;
        notifyAll();
    }

    public synchronized void consume() {
        while (empty) {
            try {
                Thread.sleep(1000);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("consumed " + product);
        product = null;
        empty = true;
        notifyAll();
    }

}

class Producer implements Runnable {
    private Job job;

    public Producer(Job job) {
        this.job = job;
    }

    @Override
    public void run() {
        while (job.id.get() <= job.quantity) {
            job.produce();
        }
    }
}

class Consumer implements Runnable {
    private Job job;

    public Consumer(Job job) {
        this.job = job;
    }

    @Override
    public void run() {
        while (job.id.get() <= job.quantity) {
            job.consume();
        }
    }
}
