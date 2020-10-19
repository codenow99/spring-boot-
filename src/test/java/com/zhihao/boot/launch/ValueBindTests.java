package com.zhihao.boot.launch;

import com.zhihao.boot.launch.model.Employee;
import com.zhihao.boot.launch.model.Family;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ValueBindTests {

    @Resource
    Family family;

    @Resource
    Employee employee;

    @Test
    public void valueBindTest() throws Exception {
        System.out.println(family.toString());
    }

    @Test
    public void valueBindTest2(){
        System.out.println(employee.toString());
    }
}
