package com.zhihao.boot.launch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Builder
@AllArgsConstructor//全参构造
@NoArgsConstructor//无参构造
public class LombokPOJO {

    //private static final Logger log = java.util.logging.Logger.getLogger(LombokPOJO.class);
    private String name;
    private Integer age;
}
