package concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {
    private Map<Long, String> cache = new HashMap<>();
    private java.util.concurrent.locks.ReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock readLock = lock.readLock();
    private Lock writeLock = lock.writeLock();

    private void method1() {
        System.out.println("start");
        ExecutorService executor = Executors.newFixedThreadPool(20);
        try {
            for (int i = 0; i < 4; i++) {
                executor.submit(new Producer());
            }
        } finally {
            executor.shutdown();
        }
    }

    private String get(Long key) {
        readLock.lock();
        try {
            return cache.get(key);
        } finally {
            readLock.unlock();
        }
    }

    private String put(Long key, String value) {
        writeLock.lock();
        try {
            return cache.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReadWriteLock().method1();
    }

    class Producer implements Callable<String> {

        private Random random = new Random();

        @Override
        public String call() throws Exception {
            while (true) {
                long key = random.nextInt(1_000);
                put(key, Long.toString(key));
                if (get(key) == null) {
                    System.out.println("no item with key = " + key);
                }
            }
        }
    }

}
