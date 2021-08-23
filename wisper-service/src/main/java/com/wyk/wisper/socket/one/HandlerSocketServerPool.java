package com.wyk.wisper.socket.one;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wuyongkang
 * @date 2021年08月10日 16:37
 */
public class HandlerSocketServerPool {
    private ExecutorService executorService;

    public HandlerSocketServerPool(int maximumPoolSize, int workQueue) {
        executorService = new ThreadPoolExecutor(3, maximumPoolSize,
                120, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(workQueue));
    }

    public void execute(Runnable target) {
        executorService.execute(target);
    }

}