package cn.injava.spring.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * 使用ehcache缓存的例子
 * User: Green lei
 * Date: 15-4-24
 * Time: 下午7:31
 */
@Component
public class CacheDataService {

    //This "movieFindCache" is delcares in ehcache.xml
    @Cacheable(value="movieFindCache")
    public String getCarData() {
        return "Hello Data";
    }

}
