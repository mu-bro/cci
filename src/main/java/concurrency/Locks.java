package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locks {
    private static final int MAX_SIZE = 10;
    List<Integer> buffer = new ArrayList<>();
    Lock lock = new ReentrantLock();
    Condition isFull = lock.newCondition();
    Condition isEmpty = lock.newCondition();
    int count = 0;


    public void workConsumerProducer() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(20);
        Consumer consumer = new Consumer();
        Producer producer = new Producer();
        executor.submit(producer);
        Thread.sleep(100);
        executor.submit(consumer);
//        for (int i = 0; i < 10; i++) {
//        //    Thread.sleep(100);
//        }
    }

    public void syns() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(20);
        Object monitor = new Object();

        for (int i = 0; i < 5; i++) {
            executor.submit(() -> {
                try {
                    synMethod(monitor);
                } catch (InterruptedException e) {
                }
            });
        }
    }

    private void synMethod(Object monitor) throws InterruptedException {

        synchronized (monitor) {
            count++;
            if (count == 5) {
                System.out.println(Thread.currentThread().getName() + ": NOTIFY");
                monitor.notifyAll();
            }
            System.out.println(Thread.currentThread().getName() + ": inside syn");
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + ": waiting");
            monitor.wait();
            System.out.println(Thread.currentThread().getName() + ": waking up");
            Thread.sleep(1000);

            System.out.println(Thread.currentThread().getName() + ": quit up");
        }

    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("start");
//        new Locks().syns();
        new Locks().workConsumerProducer();
    }

    class Consumer implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("Consumer start");
            int count = 0;
            while (count++ < 50) {
                try {
                    lock.lock();
                    System.out.println("Lock");
                    while (buffer.isEmpty()) {
                        System.out.println("empty buffer");
                        isEmpty.await();
                        Thread.sleep(500);
                    }
                    buffer.remove(buffer.size() - 1);
                    System.out.println("Remove");
                    Thread.sleep(300);
                    isFull.signalAll();
                } finally {
                    lock.unlock();
                }
            }
            System.out.println("Consumed " + (count - 1));
            return "Consumed " + (count - 1);
        }
    }

    class Producer implements Callable<String> {

        @Override
        public String call() throws Exception {
            int count = 0;
            while (count++ < 50) {
                try {
                    lock.lock();
                    while (buffer.size() >= MAX_SIZE) {
                        System.out.println("full buffer");
                        isFull.await();
//                        Thread.sleep(500);
                    }
                    buffer.add(1);
                    System.out.println("Add");
                    Thread.sleep(300);
                    isEmpty.signalAll();
                } finally {
                    lock.unlock();
                }
            }
            System.out.println("Produced " + (count - 1));
            return "Produced " + (count - 1);
        }
    }
}
