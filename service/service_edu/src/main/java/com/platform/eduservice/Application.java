package com.platform.eduservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Description：
 *
 * @author yanwei
 * Date: 2021/4/20 10:05
 **/
@SpringBootApplication
@ComponentScan(basePackages = {"com.platform"})
@EnableSwagger2 //swagger注解

public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
