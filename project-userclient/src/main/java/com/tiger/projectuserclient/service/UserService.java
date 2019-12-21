package com.tiger.projectuserclient.service;

import com.alibaba.druid.sql.PagerUtils;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tiger.projectuserclient.domain.TUser;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 用户service  接口类
 *
 * @author mytiger
 * @date 2019-12-19
 */
public interface UserService  extends IService<TUser> {
    /**
     * 查询全操作 可带入对应的where 条件
     * @param queryWrapper
     * @return   返回对应的集合
     */
    List<TUser> selectList(Wrapper<TUser> queryWrapper);

    /**
     * 根据 ID 查询
     *
     * @param id 主键ID
     * @return  返回对应的entity
     */
    TUser selectById(Serializable id);

    /**
     * 根据 entity 条件，查询一条记录
     *
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     * @return  返回符合结果的entity
     */
    TUser selectOne(Wrapper<TUser> queryWrapper);
}


