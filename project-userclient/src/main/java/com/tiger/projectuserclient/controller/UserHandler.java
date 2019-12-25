package com.tiger.projectuserclient.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.tiger.projectcommon.common.httpcode.code;
import com.tiger.projectcommon.common.json.JsonResult;
import com.tiger.projectcommon.common.jwt.JwtUtils;
import com.tiger.projectuserclient.domain.TUser;
import com.tiger.projectuserclient.redisutils.RedisUtils;
import com.tiger.projectuserclient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
    private JsonResult jsonResult = new JsonResult();
    private JwtUtils jwtUtils = new JwtUtils();
    @Autowired
    private RedisUtils redisConfig;
    @GetMapping("/index")
    public JsonResult index() {
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("id", 1);
        List<TUser> item = service.selectList(queryWrapper);
        jsonResult.setData(item);
        return jsonResult;
    }

    /**
     * 登录操作
     *
     * @param user 用户模型
     * @return 返回json code message
     */
    @PostMapping("/login")
    public JsonResult login(@RequestBody @Validated TUser user) throws Exception {

        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("Id","username","status","password").likeRight("username",user.getUsername());
        TUser tUser = service.selectOne(queryWrapper);

        if (tUser == null) {

            jsonResult.setCode(code.ERROR_601.getCode().toString());
            jsonResult.setMsg(code.ERROR_601.getMessage());
        } else if (!tUser.getPassword().equals(user.getPassword())) {

            jsonResult.setCode(code.ERROR_602.getCode().toString());
            jsonResult.setMsg(code.ERROR_602.getMessage());
        } else {
            ///生成JWT  放入redis
            Map<String, Object> map = new HashMap<>();
            map.put("id", tUser.getId());
            map.put("name", tUser.getUsername());
            map.put("status", 1);
            String token = jwtUtils.geneJsonWebToken(tUser.getId().toString(), tUser.getUsername(), map, 6000l, tUser.getUsername());
            redisConfig.set("musere", tUser, 60l, TimeUnit.SECONDS);
            ///////////
            jsonResult.setCode(code.SUCCESS_200.getCode().toString());
            jsonResult.setMsg(code.SUCCESS_200.getMessage());
            jsonResult.setToken(token);
            jsonResult.setData(tUser.getUsername());
        }
        return jsonResult;

    }


}
