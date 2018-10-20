package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Semaphores {

    Semaphore semaphore = new Semaphore(2);

    private void start() {
        try {
            semaphore.acquire();
            Thread.sleep(5000);
            System.out.println("Thread: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
        } finally {
            semaphore.release();
        }
    }

    public void work() {
        Runnable runnable = () -> start();

        ExecutorService executor = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            executor.submit(runnable);
        }
    }

    public static void main(String[] args) {
        System.out.println("start");
        Semaphores work = new Semaphores();
        work.work();
    }

}
