package com.zhihao.boot.launch;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ImportResource(locations = {"classpath:beans.xml"})
public class ImportResourceTests {

    @Autowired
    private ConfigurableApplicationContext ioc;

    @Test
    public void testHelloService() {
        //测试Spring上下文环境中是否有testBeanService这样一个bean，有的话表示xml配置文件生效
        boolean testBeanService = ioc.containsBean("testBeanService");
        System.out.println(testBeanService);
    }
}