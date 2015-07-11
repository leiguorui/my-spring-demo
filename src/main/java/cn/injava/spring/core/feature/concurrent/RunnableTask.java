package cn.injava.spring.core.feature.concurrent;

/**
 * 例子：一个无线循环的线程
 *
 * 与 RunnableTask 类，联合使用
 *
 * Created by Administrator on 2015/7/11.
 */
public class RunnableTask implements Runnable{
    @Override
    public void run() {
        while(true){
            //do something

            try {
                Thread.sleep(10*1000); // Waiting before run.
            } catch (InterruptedException e) {
                //A thread cannot process an interrupt while it's sleeping.  restore interrupted status
                //当threadPoolTaskExecutor.shutdown()，会抛出这个异常，捕获之后结束循环
                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.println("stopping thread");
    }
}
