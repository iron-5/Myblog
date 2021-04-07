package com.example.myblog3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.example.myblog3.mapper")
@SpringBootApplication
public class Myblog3Application {

    public static void main(String[] args) {

        SpringApplication.run(Myblog3Application.class, args);
//    String[] beans =  SpringApplication.run(Myblog3Application.class, args).getBeanDefinitionNames();
//        for (String bean: beans
//             ) {
//            System.out.println(bean);
//        }
    }

}
