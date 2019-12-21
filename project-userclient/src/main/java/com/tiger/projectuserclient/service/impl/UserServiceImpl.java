package com.tiger.projectuserclient.service.impl;

import com.alibaba.druid.sql.PagerUtils;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tiger.projectuserclient.domain.TUser;
import com.tiger.projectuserclient.mapper.UserMapper;
import com.tiger.projectuserclient.service.UserService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 用户service  实现类
 *
 * @author mytiger
 * @date 2019-12-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, TUser>implements UserService {
    //baseMapper 来自继承的ServiceImpl
    /**
     * 查询全操作 可带入对应的where 条件
     * @param queryWrapper
     * @return   返回对应的集合
     */
    @Override
    public List<TUser> selectList(Wrapper<TUser> queryWrapper) {
        return baseMapper.selectList(queryWrapper);
    }

    /**
     * 根据 ID 查询
     *
     * @param id 主键ID
     * @return  返回对应的entity
     */
    @Override
    public TUser selectById(Serializable id) {
        return  baseMapper.selectById(id);
    }

    /**
     * 根据 entity 条件，查询一条记录
     *
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     * @return  返回符合结果的entity
     */
    @Override
    public TUser selectOne(Wrapper<TUser> queryWrapper) {
        return baseMapper.selectOne(queryWrapper);
    }
}
