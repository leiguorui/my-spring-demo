package cn.injava.spring.core.feature.concurrent;

/**
 * ���ӣ�һ������ѭ�����߳�
 *
 * �� RunnableTask �࣬����ʹ��
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
                //��threadPoolTaskExecutor.shutdown()�����׳�����쳣������֮�����ѭ��
                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.println("stopping thread");
    }
}
