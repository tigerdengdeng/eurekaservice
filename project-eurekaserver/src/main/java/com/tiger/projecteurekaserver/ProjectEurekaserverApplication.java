package com.tiger.projecteurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
/**
 * eureka 注册服务中心 注解
 */
@EnableEurekaServer
public class ProjectEurekaserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectEurekaserverApplication.class, args);
    }

}
