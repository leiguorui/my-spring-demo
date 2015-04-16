package cn.injava.spring.schedul;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring + quartz定时器
 * 教程：http://www.mkyong.com/spring/spring-quartz-scheduler-example/
 * User: Administrator
 * Date: 15-4-16
 * Time: 上午11:34
 */
public class SchedulApp {
    public static void main( String[] args ) throws Exception{
        new ClassPathXmlApplicationContext("Spring-Quartz.xml");
    }
}
