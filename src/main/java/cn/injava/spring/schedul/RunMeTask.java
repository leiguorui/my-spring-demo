package cn.injava.spring.schedul;

/**
 * 定时器的任务，写具体的定时方法，由job调用
 * User: Administrator
 * Date: 15-4-16
 * Time: 上午10:44
 */
public class RunMeTask {

    public void printMe() {
        System.out.println("Spring 3 + Quartz 1.8.6 ~");
    }

}
