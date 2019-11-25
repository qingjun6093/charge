package com.jiangjq.charge.concurrent;

import com.jiangjq.charge.ChargeApplicationTests;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


/**
 * @author jiangjunqing
 * @date 2019/11/25
 * @desc
 */
public class CyclicBarrierTest extends ChargeApplicationTests {
    private static Logger logger = LoggerFactory.getLogger(CyclicBarrierTest.class);

    @Autowired
    private AsyncService asyncService;

    @Autowired
    private JjqExecutor jjqExecutor;


    /**
     *如果使用线程池跑,不是每次都能获得预期想效果,因为线程池存在线程复用的情况
     * @throws Exception
     */
    @Test
    public void testSpringBoot() throws Exception{
        int parties = 5;
        final CyclicBarrier cb = new CyclicBarrier(parties);
        int n = parties;
        //int n = parties-1;
        //int n = parties+1;
        for (int i=0; i< n ; i++) {
            asyncService.CyclicBarrier(cb);
        }
    }

    /**
     * n=parties或者parties+1,能获取想要结果
     * n = parties-1,因为线程数不够,CyclicBarrier永远也达不到的放行条件,所以控制台没有输出.
     * @throws Exception
     */
    @Test
    public void testRunnable(){
        int parties = 10;
        final CyclicBarrier cb = new CyclicBarrier(parties);
        //int n = parties;
        int n = parties+1;
        //int n = parties-1;
        for (int i=0; i< n ; i++) {
            new Thread(new jjqRunnable(cb)).start();
        }
    }

    private class jjqRunnable implements Runnable {
        public jjqRunnable(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            doSomething(cyclicBarrier);
        }

        private void doSomething(CyclicBarrier cyclicBarrier){
            try {
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName()+"--"+System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
        CyclicBarrier cyclicBarrier;

        public CyclicBarrier getCyclicBarrier() {
            return cyclicBarrier;
        }

        public void setCyclicBarrier(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }
    }

}
