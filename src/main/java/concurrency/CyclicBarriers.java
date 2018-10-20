package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CyclicBarriers {

    private void start() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        CyclicBarrier barrier = new CyclicBarrier(4, () -> System.out.println("We all here"));
        List<Future<String>> futures = new ArrayList<>();

        try {
            for (int i = 0; i < 4; i++) {
                Friend friend = new Friend(barrier);
                futures.add(executorService.submit(friend));
            }

            futures.forEach(
                    future -> {
                        try {
                            future.get();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
            );
        } finally {
            executorService.shutdown();
        }
    }

    public static void main(String[] args) {
        System.out.println("start");
        CyclicBarriers work = new CyclicBarriers();
        work.start();
    }

    class Friend implements Callable<String> {
        private CyclicBarrier barrier;

        public Friend(CyclicBarrier barrier) {
            this.barrier = barrier;
        }


        @Override
        public String call() throws Exception {
            Random random = new Random();
            Thread.sleep(random.nextInt(30) * 100 + 100);
            System.out.println(Thread.currentThread().getName() + ": I arrived, waiting for the others...");

            barrier.await();

            System.out.println(Thread.currentThread().getName() + ": Let's go");
            return "ok";
        }
    }
}


