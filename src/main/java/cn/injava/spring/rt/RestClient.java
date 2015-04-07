package cn.injava.spring.rt;

import cn.injava.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * spring 对rest service的post get的操作
 *
 * 教程：
 * 1.http://stackoverflow.com/questions/12728006/resttemplate-post-for-entity
 * 2.http://learningviacode.blogspot.com/2013/06/using-springs-resttemplate-class.html
 *
 * User: Administrator
 * Date: 15-4-7
 * Time: 上午10:39
 */
@Component(value = "restClient")
public class RestClient {
    @Autowired
    private RestTemplate restTemplate;

    private final static String userServiceUrl = "http://localhost:8080/SampleRest/api/user/";

    public User getUser(final int id) {
        return this.restTemplate.getForObject(userServiceUrl + "{id}",
                User.class, id);
    }

    public String postUser(Map<String, String> paramsMap){
        MultiValueMap<String, Object> parts = new LinkedMultiValueMap<String, Object>();

        for (Map.Entry<String, String> entry : paramsMap.entrySet()){
            parts.add(entry.getKey(), entry.getValue());
        }

        Object response = restTemplate.postForObject("http://localhost:8080/user/", parts, String.class);

        return response.toString();
    }

    public static void main(final String[] args) {
        final ApplicationContext appContext = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        final RestClient restClient = (RestClient) appContext
                .getBean("restClient");
        final User user = restClient.getUser(1);
        System.out.println(user.getName() + " is of age " + user.getAge());
    }
}
