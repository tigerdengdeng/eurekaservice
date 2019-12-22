package com.tiger.projectuserclient.mapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.injector.methods.SelectById;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.tiger.projectuserclient.domain.TUser;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * 用户 mapper接口  并集成mybatisPlus的BaseMapper
 *
 * @author mytiger
 * @dae  2019-12-21
 */
public interface UserMapper extends BaseMapper<TUser> {

    /**
     * 根据 entity 条件，查询全部记录
     *
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     * @return   返回对应的集合
     */
    @Override
    List<TUser> selectList(@Param("ew") Wrapper<TUser> queryWrapper);

    /**
     * 根据 ID 查询
     *
     * @param id 主键ID
     * @return  返回对应的entity
     */
    @Override
    TUser selectById(Serializable id);

    /**
     * 根据 entity 条件，查询一条记录
     *
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     * @return  返回符合结果的entity
     */
    @Override
    TUser selectOne(@Param(Constants.WRAPPER) Wrapper<TUser> queryWrapper);



}
