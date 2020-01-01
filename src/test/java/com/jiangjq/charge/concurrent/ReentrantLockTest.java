package com.jiangjq.charge.concurrent;

import com.jiangjq.charge.ChargeApplicationTests;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jiangjunqing
 * @date 2019/11/25
 * @desc 可重入锁学习
 */
public class ReentrantLockTest extends ChargeApplicationTests {
    private static Logger logger = LoggerFactory.getLogger(ReentrantLockTest.class);


//    @Test
//    public void reentrantLock(){
//        int r = 1;
//        ReentrantLock lock = new ReentrantLock(true);
//        lock.lock();
//        try {
//            ++r;
//            lock.lock();
//            --r;
//        }finally {
//            lock.unlock();
//        }
//
//        logger.info("r:{}", r);
//    }


    @Test
    public void reentrantLock(){
        new Thread(new JjqRunnable()).start();
    }

    private class JjqRunnable implements Runnable {
        @Override
        public void run() {
            int r = 1;
            ReentrantLock lock = new ReentrantLock();
            //调用lock,state = state+1
            lock.lock();
            try {
                ++r;
                //调用lock,state = state+1
                lock.lock();
                --r;
            }finally {
                //state = state - 1
                lock.unlock();
            }
            logger.info("r:{}", r);
        }
    }


    /**
     * 只能有一个线程加锁成功
     * @throws InterruptedException
     */
    @Test
    public void reentrantLock1() throws InterruptedException {
        final  ReentrantLock lock = new ReentrantLock();
        ExecutorService executorService = Executors.newCachedThreadPool();
        int pool = 4;
        for (int i = 0; i < pool; i++) {
            //final int threadNum=i;
            executorService.execute(() -> {
                lock.lock();
                System.out.println(lock.toString());
            });
        }


    }







}
