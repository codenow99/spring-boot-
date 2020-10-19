package com.zhihao.boot.launch.model;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Data
@Configuration
@PropertySource (name = "employeeProperties",
        value = "classpath:employee.properties",
        encoding = "utf-8")
public class Employee {

    //使用SpEL读取employee.properties配置文件
    @Value("#{'${employee.names}'.split(',')}")
    private List<String> employeeNames;

}