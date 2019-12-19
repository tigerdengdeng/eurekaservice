package com.tiger.projectuserclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
/**
 * 客户端依赖   只要添加了client依赖  可以不写注解
 */
@EnableEurekaClient
//需要开启feign，告诉springboot 我整合了feign
@EnableFeignClients
//熔断器
@EnableHystrix
public class ProjectUserclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectUserclientApplication.class, args);
	}

}
