package com.zhihao.boot.launch;

import com.zhihao.boot.launch.model.Family;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CustomYamlTest {
    @Resource
    Family family;

    @Test
    public void hello(){
        System.out.println(family.toString());
    }
}
