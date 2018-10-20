package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExecutorsWork {

    Lock lock = new ReentrantLock();

    private void start() {
        try {
            lock.lock();
            Thread.sleep(5000);
            System.out.println("Thread: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
        } finally {
            lock.unlock();
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
        ExecutorsWork work = new ExecutorsWork();
        work.work();
    }

}
