package com.jiangjq.charge.concurrent;

import com.jiangjq.charge.ChargeApplicationTests;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @author jiangjunqing
 * @date 2019/11/25
 * @desc 信号量学习
 */
public class SemaphoreTest extends ChargeApplicationTests {
    private static Logger logger = LoggerFactory.getLogger(SemaphoreTest.class);


    /**
     *打印10个线程输出结果
     * 如果new JjqRunnable(semaphore, 2),那么将输出5个结果
     */
    @Test
    public void testRunnable(){
        int permits = 10;
        final Semaphore semaphore = new Semaphore(permits);
        int n = permits * 10;
        for (int i=0; i< n ; i++) {
            new Thread(new JjqRunnable(semaphore, 1)).start();
        }
    }

    private class JjqRunnable implements Runnable {
        public JjqRunnable(Semaphore semaphore, int permits) {
            this.semaphore = semaphore;
            this.permits = permits;
        }
        @Override
        public void run() {
            doSomething(semaphore, permits);
        }
        private void doSomething(Semaphore semaphore, int permits){
            try {
                semaphore.acquire(permits);
                System.out.println(Thread.currentThread().getName() + "--" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Semaphore semaphore;
        int permits;
        public Semaphore getSemaphore() {
            return semaphore;
        }
        public void setSemaphore(Semaphore semaphore) {
            this.semaphore = semaphore;
        }
        public int getPermits() {
            return permits;
        }
        public void setPermits(int permits) {
            this.permits = permits;
        }
    }

}
