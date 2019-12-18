package com.tiger.projectuserclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
/**
 * 客户端依赖   只要添加了client依赖  可以不写注解
 */
//@EnableEurekaClient
public class ProjectUserclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectUserclientApplication.class, args);
	}

}
