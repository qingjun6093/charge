package com.jiangjq.charge.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author jjq
 * @version 1.0
 * @date 2019/11/22
 * @desc
 */
public class Worker implements Runnable {
    private  CountDownLatch start;
    private  CountDownLatch done;


    public Worker(CountDownLatch start, CountDownLatch done) {
        this.start = start;
        this.done = done;
    }

    @Override
    public void run() {
        try {
            start.await();
            doWork();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    private void doWork(){
        String name = Thread.currentThread().getName();
        System.out.println("do-work-"+name);
    }
}
