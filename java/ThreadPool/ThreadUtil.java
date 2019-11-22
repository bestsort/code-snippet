package com.hibegin.common.util.threadpool;

import java.util.concurrent.*;

/**
 * @author bestsort
 * @date 2019/11/22 下午3:27
 * @description 符合 《阿里Java开发规约》 的线程创建方式
 */

public class ThreadUtil {
    private static int CORE_POOL_SIZE = 5;
    private static int MAX_POOL_SIZE = 10;
    private static int QUEUE_CAPACITY = 100;
    private static Long KEEP_ALIVE_TIME = 1L;
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(
            CORE_POOL_SIZE,
            MAX_POOL_SIZE,
            KEEP_ALIVE_TIME,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(QUEUE_CAPACITY),
            new ThreadPoolExecutor.CallerRunsPolicy()
    );
    public static void execute(Runnable worker){
        executor.execute(worker);
    }
}
