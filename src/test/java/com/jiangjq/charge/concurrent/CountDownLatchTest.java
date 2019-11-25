package com.jiangjq.charge.concurrent;

import com.jiangjq.charge.ChargeApplicationTests;
import com.jiangjq.charge.concurrent.countdownlatch.Worker;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jjq
 * @version 1.0
 * @date 2019/11/22
 * @desc
 */
public class CountDownLatchTest  extends ChargeApplicationTests {
    private static Logger logger = LoggerFactory.getLogger(CountDownLatchTest.class);

    /**
     * 1.获取state,r=(getState() == 0) ? 1 : -1;
     * 2.r>=0,放行;否则unpack线程,放入队列
     * @throws InterruptedException
     */
    @Test
    public void test() throws InterruptedException {
        int n=5;
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(n);

        for (int i= 0;i<6;i++){
            new Thread(new Worker(start,done)).start();
        }
        System.out.println("======all threads are prepare============");
        start.countDown();
    }


    @Test
    public  void xiix() throws InterruptedException{
        ExecutorService executorService = Executors.newCachedThreadPool();
        int pool=10, c=6;
        CountDownLatch countDownLatch=new CountDownLatch(c);
        for (int i=0;i<pool;i++){
            //final int threadNum=i;
            executorService.execute(()-> {
                countDownLatch.countDown();
                System.out.println(countDownLatch.getCount());
            });
        }

        countDownLatch.await();
        System.out.println("CountDownLatch --- finish:"+countDownLatch.getCount());
        executorService.shutdown();
    }






}
