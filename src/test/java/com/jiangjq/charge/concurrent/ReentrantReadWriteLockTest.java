package com.jiangjq.charge.concurrent;

import com.jiangjq.charge.ChargeApplicationTests;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author jiangjunqing
 * @date 2019/11/25
 * @desc 可重入的读写锁
 * @see java.util.concurrent.locks.ReentrantReadWriteLock
 */
public class ReentrantReadWriteLockTest extends ChargeApplicationTests {
    private static Logger logger = LoggerFactory.getLogger(ReentrantReadWriteLockTest.class);

    @Autowired
    private JjqExecutor jjqExecutor;


    /**
     *reentrantReadWriteLock里面维护了一对锁(ReadLock和WriteLock)
     *写锁对其他线程不可见(排他锁),读锁对其他线程可见(共享锁)
     *
     */
    @Test
    public void reentrantReadWriteLock(){
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

        int count =5;
        ThreadPoolTaskExecutor executor = jjqExecutor.jjqSpringExecutor();
        for (int i=0; i<count; i++){
            executor.submit(new JjqRunnable(reentrantReadWriteLock));
        }
    }


    private class JjqRunnable implements Runnable {
        private  ReentrantReadWriteLock reentrantReadWriteLock;

        @Override
        public void run() {
            doSomething(reentrantReadWriteLock);
        }
        private void doSomething(ReentrantReadWriteLock reentrantReadWriteLock){
            reentrantReadWriteLock.readLock().lock();
            //reentrantReadWriteLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "--start");
            System.out.println(Thread.currentThread().getName() + "--" + System.currentTimeMillis());
            System.out.println(Thread.currentThread().getName() + "--end\n");
            reentrantReadWriteLock.readLock().unlock();
            //reentrantReadWriteLock.writeLock().unlock();
        }

        public JjqRunnable(ReentrantReadWriteLock reentrantReadWriteLock) {
            this.reentrantReadWriteLock = reentrantReadWriteLock;
        }

    }
}
