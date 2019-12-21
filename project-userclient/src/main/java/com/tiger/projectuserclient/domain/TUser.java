package com.tiger.projectuserclient.domain;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 用户实体类
 *
 * @author mytiger
 * @date 2019-12-21
 */
//lombok 简化get set 等操作
@Data
//指定 数据库对应的表  解决表名和生成的实体名称出现不一致的情况  例：驼峰 下划线
@TableName("t_user")
public class TUser implements Serializable {
    /**
     * @NotNull 适用于任何类型被注解的元素必须不能与NULL
     * @NotEmpty 适用于String Map或者数组不能为Null且长度必须大于0
     * @NotBlank 只能用于String上面 不能为null,调用trim()后，长度必须大于0
     */

    //    用户ID 主键
    @TableId  //代表数据库主键一列     解决主键名称和生成的实体名称出现不一致的情况
    private Integer id;


    //    用户名
    @NotBlank(message = "用户名不能为空")
    @NotNull(message = "用户名不能为空")
    @TableField("username")   // 指定数据库表中对应的字段  解决实体类当中生成字段名称和数据库当中不一致的情况
    private String username;


    //    密码
    @NotBlank(message = "密码不能为空")
    @NotNull(message = "密码不能为空")
    private String password;



    //     状态(0启用,1禁用)
    private Integer status;


    //补充字段  表中不存在    transient 不序列化  static 序列化
    @TableField(exist = false) //false 表示不属于数据库当中字段  可以作为补充字段调用
    private static String remark;
}
