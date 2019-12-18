package com.tiger.projectuserclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserHandler {

    @Value("${server.port}")
    private  String port;

    @Value("${spring.application.name}")
    private  String name;
    @GetMapping("/index")
    public String index() {
        return "user服务的端口是" + this.port+this.name;
    }
}
