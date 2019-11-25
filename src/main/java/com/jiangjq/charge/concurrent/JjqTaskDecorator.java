package com.jiangjq.charge.concurrent;

import org.springframework.core.task.TaskDecorator;

import java.util.concurrent.Semaphore;

/**
 * @author jiangjunqing
 * @date 2019/11/22
 * @desc TaskDecorator的实现
 */
public class JjqTaskDecorator implements TaskDecorator {

    private Semaphore semaphore;

    public JjqTaskDecorator(Semaphore semaphore) {
        System.out.println("init JjqTaskDecorator");
        this.semaphore = semaphore;
    }

    @Override
    public Runnable decorate(Runnable runnable) {

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                if (semaphore != null) {
                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        runnable.run();
                        semaphore.release();
                    }
                }
            }
        };

        return runnable1;
    }
}
