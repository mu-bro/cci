package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class BlockingQueues {
    private static final int MAX_SIZE = 10;
    BlockingQueue<String> queue = new ArrayBlockingQueue<>(50);

    int count = 0;


    public void workConsumerProducer() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(20);
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futures.add(executor.submit(new Consumer()));
            futures.add(executor.submit(new Producer()));
        }

        try {
            futures.forEach(future -> {
                try {
                    future.get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } finally {
            executor.shutdown();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        System.out.println("start");
        new BlockingQueues().workConsumerProducer();
        System.out.println("finish");
    }

    class Consumer implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("Consumer start");
            int count = 0;
            while (count++ < 50) {
                queue.take();
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
                queue.put(Integer.toString(count));
            }
            System.out.println("Produced " + (count - 1));
            return "Produced " + (count - 1);
        }
    }
}
