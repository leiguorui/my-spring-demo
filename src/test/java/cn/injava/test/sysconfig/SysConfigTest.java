package cn.injava.test.sysconfig;

import cn.injava.spring.core.feature.test.TestSupport;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

/**
 * 单元测试，用于测试系统配置文件sys-config.properties
 */
public class SysConfigTest extends TestSupport {
    @Value("#{sysConfigProperties['sys.key']}")
    private String sysKey;

    @Test
    public void test_sysConfig() {
        start();
        System.out.println(sysKey);
        end();
    }
}
