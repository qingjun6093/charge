package com.jiangjq.charge.concurrent;

import com.jiangjq.charge.ChargeApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author jjq
 * @version 1.0
 * @date 2019/11/30
 * @desc
 */
public class FutureTest extends ChargeApplicationTests {

    @Autowired
    private AsyncService asyncService;
    @Test
    public void test() {
        Future<Long> future = asyncService.futureTest();
        try {
            Long aLong = future.get();
            System.out.println(aLong);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
    //输出"
    //1575122770472
    //end

    @Autowired
    private JjqExecutor jjqExecutor;

    @Test
    public void test2() throws ExecutionException, InterruptedException {
        Future<?> submit = jjqExecutor.jjqSpringExecutor().submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //get方法会阻塞当前线程
        //Object o = submit.get();
        System.out.println("end");
    }

}
