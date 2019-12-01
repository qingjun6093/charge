package com.jiangjq.charge.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;


/**
 * @author jiangjunqing
 * @date 2019/11/22
 * @desc
 */
@Component
public class AsyncService {
    private static Logger logger = LoggerFactory.getLogger(AsyncService.class);


    @Async
    public Future<Long> getCurrentTime(){
        return new AsyncResult<>(System.currentTimeMillis());
    }

    @Async
    public Future<Long> futureTest(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<>(System.currentTimeMillis());
    }

    @Async
    public void printCurrentTime() {
        System.out.println(Thread.currentThread().getName()+"--"+System.currentTimeMillis());
    }

    @Async
    public void CyclicBarrier(CyclicBarrier cb) throws BrokenBarrierException, InterruptedException {
        System.out.println(Thread.currentThread().getName()+"--"+System.currentTimeMillis());
        cb.await();
    }
}
