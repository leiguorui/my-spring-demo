package cn.injava.spring.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * springÈÝÆ÷µÄ¼àÌýÆ÷£¬µ±ÈÝÆ÷Æô¶¯£¬»áÖ´ÐÐonApplicationEvent()
 *
 * Application listeners run synchronously in Spring.
 *
 * If you want to make sure you're code is executed only once, just keep some state in your component.
 *
 * Created by Green Lei on 2015/8/7 11:36.
 */
@Component
public class StartupHousekeeper implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        System.out.println("StartupHousekeeper has started!");
    }
}