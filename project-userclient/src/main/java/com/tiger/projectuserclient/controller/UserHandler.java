package com.tiger.projectuserclient.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tiger.projectuserclient.domain.TUser;
import com.tiger.projectuserclient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户controller
 *
 * @author mytiger
 * @date   2019-12-21
 */
@RestController
@RequestMapping("/user")
public class UserHandler {

@Autowired
public UserService service;

    @GetMapping("/index")
    public String index() {
        QueryWrapper<TUser>queryWrapper=new QueryWrapper<>();
        queryWrapper.likeRight("id",1);
        List<TUser> item=  service.selectList(queryWrapper);
        return "用户数据是" + item;
    }

    public
}
