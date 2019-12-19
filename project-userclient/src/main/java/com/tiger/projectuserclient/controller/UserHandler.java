package com.tiger.projectuserclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserHandler {
@Autowired
private DiscoveryClient client;

    @Value("${server.port}")
    private  String port;

    @Value("${spring.application.name}")
    private  String name;
    @GetMapping("/index")
    public String index() {
        return "user服务的端口是" + this.port+this.name;
    }
}
