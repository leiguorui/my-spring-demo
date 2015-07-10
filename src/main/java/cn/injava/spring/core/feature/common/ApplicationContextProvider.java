package cn.injava.spring.core.feature.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 获取当前 ApplicationContext
 *
 * 参考：http://stackoverflow.com/questions/21827548/spring-get-current-applicationcontext
 *
 *  the best way to get application context anywhere,
 *
 * Created by Administrator on 2015/7/10.
 */
public class ApplicationContextProvider implements ApplicationContextAware{

    private static ApplicationContext context;

    public static ApplicationContext getApplicationContext() {
        return context;
    }

    @Override
    public void setApplicationContext(ApplicationContext ac)
            throws BeansException {
        context = ac;
    }
}