package com.tigert.projectzuulserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
/**
 * 网关依赖  开启代理功能
 */
@EnableZuulProxy
public class ProjectZuulserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectZuulserverApplication.class, args);
	}

}
