package com.server.Concurrency.examples.concurrent;

import com.server.Concurrency.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.*;

/**
 * 线程安全类  ConcurrentSkipListMap
 */

@Slf4j
@ThreadSafe
public class ConcurrentSkipListMapExample {

    private static int clientTotal = 5000;

    private static int threadTotal = 200;

    private static Map<Integer,Integer> hashMap = new ConcurrentSkipListMap<>();

    public static void main(String[] args) throws InterruptedException {

        ExecutorService pool = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for(int i = 0;i<clientTotal;i++){
            int count = i;
            pool.execute(()->{
                try {
                    semaphore.acquire();
                    update(count);
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception"+e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        pool.shutdown();
        log.info("size:{}", hashMap.size());
    }

    private static void update(int threadNo) {
        hashMap.put(threadNo,threadNo);
    }

}
