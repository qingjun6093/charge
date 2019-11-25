package com.jiangjq.charge.concurrent;

import com.jiangjq.charge.ChargeApplicationTests;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.ArrayList;
import java.util.concurrent.*;


/**
 * @author jiangjunqing
 * @date 2019/11/22
 * @desc
 */
public class JjqExecutorTest extends ChargeApplicationTests {
    private static Logger logger = LoggerFactory.getLogger(JjqExecutorTest.class);

    @Autowired
    private AsyncService asyncService;

    @Autowired
    private JjqExecutor jjqExecutor;

    @Test
    public void test(){
        int count = 26;
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(count);

        ThreadPoolTaskExecutor executor = jjqExecutor.jjqSpringExecutor();
        for (int i=0; i<count; i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        start.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        end.countDown();
                    }
                    logger.info("activeCount:{}, blockingQueueSize:{}, taskCount:{}",
                            executor.getActiveCount(),executor.getThreadPoolExecutor().getQueue().size(), executor.getThreadPoolExecutor().getTaskCount());
                }
            });
        }

        start.countDown();
        try {
            end.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test1() throws ExecutionException, InterruptedException {
        int count = 100;
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(count);
        Semaphore semaphore = new Semaphore(10);
        ThreadPoolTaskExecutor executor = jjqExecutor.jjqSpringExecutor();
        for (int i=0; i<count; i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("1");
//                    try {
//                        //start.await();
//
//                        semaphore.acquire();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }finally {
//                       // end.countDown();
//                        semaphore.release();
//                    }
                    logger.info("activeCount:{}, blockingQueueSize:{}, taskCount:{}",
                            executor.getActiveCount(),executor.getThreadPoolExecutor().getQueue().size(), executor.getThreadPoolExecutor().getTaskCount());
                }
            });
        }
    }

    @Test
    public void countDownLatchTest(){
        int count = 1;
        CountDownLatch countDownLatch = new CountDownLatch(count);

        ThreadPoolTaskExecutor executor = jjqExecutor.jjqSpringExecutor();
        for (int i=0; i<10; i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(System.currentTimeMillis());
                        //countDownLatch.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally {
                        //countDownLatch.countDown();
                    }
                }
            });
        }


    }


    @Test
    public void test2() throws ExecutionException, InterruptedException {
        ArrayList<Long> objects = new ArrayList<>();
        for (int i=0; i<25; i++){
            Future<Long> currentTime = asyncService.getCurrentTime();
            objects.add(currentTime.get());
        }


        logger.info("objectsSize:{}", objects.size());
    }

    @Test
    public void test3() {
        for (int i=0; i<1000; i++){
            new Thread(new jjqRunnable()).start();
        }
    }

    @Test
    public void test4() {
        for (int i=0; i<1000; i++){
            asyncService.printCurrentTime();
        }
    }

    public class jjqRunnable implements Runnable {
        @Override
        public void run() {
            asyncService.printCurrentTime();
        }
    }

















}
