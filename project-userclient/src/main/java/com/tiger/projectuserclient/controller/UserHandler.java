package com.tiger.projectuserclient.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.tiger.projectcommon.common.json.JsonResult;
import com.tiger.projectuserclient.domain.TUser;
import com.tiger.projectuserclient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户controller
 *
 * @author mytiger
 * @date 2019-12-21
 */
@RestController
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    public UserService service;

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/index")
    public JsonResult index() {
        JsonResult jsonResult = new JsonResult();
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("id", 1);
        List<TUser> item = service.selectList(queryWrapper);
        jsonResult.setData(item);
        return jsonResult;
    }

}
