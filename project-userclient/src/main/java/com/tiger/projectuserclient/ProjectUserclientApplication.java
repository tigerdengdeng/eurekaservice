package com.tiger.projectuserclient;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
/**
 * 主程序入口
 * 客户端依赖 只要添加了client依赖  可以不写注解
 *
 *
 * @author tiger
 * @date   2019-12-18
 */
@EnableEurekaClient
//需要开启feign，告诉springboot 我整合了feign
@EnableFeignClients
//熔断器
@EnableHystrix
//springboot启动类添加@MapperScan扫描mapper层接口
@MapperScan("com.tiger.projectuserclient.mapper")
public class ProjectUserclientApplication{

	public static void main(String[] args) {
		SpringApplication.run(ProjectUserclientApplication.class, args);
	}

}
