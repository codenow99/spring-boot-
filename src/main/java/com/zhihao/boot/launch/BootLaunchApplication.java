package com.zhihao.boot.launch;

import com.zhihao.boot.launch.model.LombokPOJO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootLaunchApplication {

    public static void main(String[] args) {
        LombokPOJO lombokPOJO = LombokPOJO.builder()
                .name("zhihao")
                .age(20)
                .build();

        SpringApplication.run(BootLaunchApplication.class, args);
    }

}
