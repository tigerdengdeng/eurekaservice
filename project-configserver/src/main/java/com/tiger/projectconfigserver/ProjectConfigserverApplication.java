package com.tiger.projectconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
/**
 * config 服务端注解
 */
@EnableConfigServer
public class ProjectConfigserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectConfigserverApplication.class, args);
    }

}
