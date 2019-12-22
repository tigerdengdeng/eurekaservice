package com.tiger.projectuserclient.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.tiger.projectcommon.common.json.JsonResult;
import com.tiger.projectuserclient.domain.TUser;
import com.tiger.projectuserclient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    private JsonResult jsonResult=new JsonResult();

    @GetMapping("/index")
    public JsonResult index() {
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("id", 1);
        List<TUser> item = service.selectList(queryWrapper);
        jsonResult.setData(item);
        return jsonResult;
    }


    @PostMapping("/login")
    public  JsonResult login(@RequestBody  @Validated TUser user)
    {
       TUser tUser=service.selectById(1);
        jsonResult.setData(tUser);
       return jsonResult;
    }



}
