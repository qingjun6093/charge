package com.jiangjq.charge.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * @author jiangjunqing
 * @date 2019/11/22
 * @desc
 */
@Configuration
@EnableAsync
public class JjqExecutor {
    private static Logger logger = LoggerFactory.getLogger(JjqExecutor.class);

    /**
     * 核心线程数量
     * 当一个请求进来时如果当前线程池中线程数量小于这个值，则直接通过ThreadFactory新建一个线程来处理这个请求，如果已有线程数量大于等于这个值则将请求放入阻塞队列中。
     * @see ThreadFactory
     * ThreadFactory是一个接口,java.util.concurrent和合spring框架都有对它的实现(可以能有多个)
     * java并发包的有java.util.concurrent.Executors.DefaultThreadFactory和java.util.concurrent.Executors.PrivilegedThreadFactory
     * Spring的有ThreadPoolTaskExecutor和ThreadPoolTaskScheduler等
     * 我们注意到ThreadPoolTaskExecutor同时间接实现了ThreadFactory和ThreadPoolExecutor,其实也不难理解,ThreadFactory这个接口就是创建一个线程,
     * 何不将这个创建线程的操作放到ThreadPoolTaskExecutor里面呢,这样对业务层友好很多.
     *
     */
    private int corePoolSize = 10;

    /**
     * 线程池最大数量
     * 线程池的最大线程数目，当线程池数量已经等于corePoolSize并且阻塞队列也已经满了，则看线程数量是否小于maximumPoolSize：
     * 如果小于则创建一个线程来处理请求，否则使用“饱和策略”来拒绝这个请求。
     * 对于大于corePoolSize部分的线程，称作这部分线程为“idle threads”，这部分线程会有一个最大空闲时间，如果超过这个空闲时间还没有任务进来则将这些空闲线程回收。
     *
     * 其中饱和策略有:
        CallerRunsPolicy：请求脱离线程池运行（调用者caller线程来运行这个任务）；
        AbortPolicy：抛出RejectedExecutionException异常；默认使用
        DiscardPolicy：丢弃这个任务，即什么也不做；
        DiscardOldestPolicy：将阻塞队列中等待时间最久的任务删除（即队列头部的任务），将新的任务加入队尾。
     */
    private int maxPoolSize = 20;

    /**
     *idle threads的超时时间
     * 用来控制idle threads的最大空闲时间，超过这个空闲时间空闲线程将被回收
     * ThreadPoolTaskExecutor中单位是秒,
     * ThreadPoolExecutor则可以传入TimeUnit参数指定时间的单位
     */
    private int keepAliveSeconds = 5;

    /**
     * 阻塞队列长度
     * 当corePoolSize已满时,后面进来的线程将进入阻塞队列等待,一直等待前面线程执行完归还线程资源
     * @see BlockingQueue
     * BlockingQueue是一个接口,有众多实现,常见的有:
     *  1.ArrayBlockingQueue
     *  2.LinkedBlockingQueue,spring的ThreadPoolTaskExecutor就是使用了这个
     */
    private int queueCapacity = 1000;

    @Bean
    public ThreadPoolTaskExecutor jjqSpringExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        executor.setQueueCapacity(queueCapacity);

        executor.setThreadNamePrefix("jjq-executor-");
//        Semaphore semaphore = new Semaphore(10);
//        JjqTaskDecorator jJqTaskDecorator = new JjqTaskDecorator(semaphore);
//        executor.setTaskDecorator(jJqTaskDecorator);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
        executor.initialize();
        logger.info("activeCount:{}, blockingQueueSize:{}", executor.getActiveCount(),executor.getThreadPoolExecutor().getQueue().size());
        return executor;
    }

//    @Bean
//    public Executor jjqExecutor(){
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(
//                corePoolSize,
//                maxPoolSize,
//                keepAliveSeconds,
//                TimeUnit.NANOSECONDS,
//                new LinkedBlockingQueue<>(queueCapacity)
//        );
//
//        logger.info("executor:{}", executor);
//        return executor;
//
//    }




}
