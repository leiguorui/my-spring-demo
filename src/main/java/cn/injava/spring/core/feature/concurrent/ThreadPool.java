package cn.injava.spring.core.feature.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池, 用户执行、停止线程
 *
 * 具体用法见 定时器https://github.com/leiguorui/forex-site/tree/master/src/main/java/cn/injava/forex/core/schedul
 *
 * Created by Administrator on 2015/7/11.
 */
public class ThreadPool {
    private int poolSize = 2;
    private int maxPoolSize = 5;
    private long keepAliveTime = 10;
    private ThreadPoolExecutor threadPoolExecutor = null;
    private List<FutureTask> futureTasks = new ArrayList<FutureTask>();
    private final ArrayBlockingQueue queue = new ArrayBlockingQueue(5);

    public ThreadPool() {
        System.out.println("Starting pool...");
        threadPoolExecutor = new ThreadPoolExecutor(poolSize, maxPoolSize, keepAliveTime, TimeUnit.SECONDS, queue);
    }

    public void runTask(Runnable task) {
        FutureTask futureTask = (FutureTask) threadPoolExecutor.submit(task);

        futureTasks.add(futureTask);

        System.out.println("Task count: " + queue.size());
    }

    public void shutDown() {
        threadPoolExecutor.shutdownNow();
        System.out.println("Shutting down pool...");
    }

    public void callCancel() {
        for (FutureTask futureTask : futureTasks){
            futureTask.cancel(true);
        }
        System.out.println("Cancelling...");
    }

    public int getActiveCount(){
        return threadPoolExecutor.getActiveCount();
    }
}
