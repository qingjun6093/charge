package com.jiangjq.charge.concurrent;

import org.junit.Test;

/**
 * @author jiangjunqing
 * @date 2019/12/26
 * @desc
 */
public class InterruptTest {

    /**
     * 不会抛出中断异常
     */
    @Test
    public void interruptTest(){
        System.out.println("interrupt 1");
        Thread.currentThread().interrupt();
        System.out.println("interrupt 2");
        System.out.println(Thread.currentThread().isInterrupted());
    }

    /**
     * 不会抛出中断异常
     */
    @Test
    public void interruptTes2() {
        System.out.println("interrupt 1");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread.currentThread().interrupt();
        System.out.println("interrupt 2");
        System.out.println(Thread.currentThread().isInterrupted());
    }

    /**
     * 将抛出中断异常
     * @throws InterruptedException
     */
    @Test
    public void interruptTes3(){
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("oooo");
        });
        thread.start();
        thread.interrupt();

    }


}
