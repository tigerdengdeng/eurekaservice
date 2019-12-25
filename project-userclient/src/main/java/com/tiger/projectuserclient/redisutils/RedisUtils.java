package com.tiger.projectuserclient.redisutils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * redis  工具类
 *
 * @author mytiger
 * @date  2019-15-26
 */
@Component
public class RedisUtils {

    /**
     * 注入Redis data
     *
     */
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 存入缓存
     * @param key  key值
     * @param object  values 值
     * @return 是否成功
     */
    public boolean set(String key, Object object)
    {
        boolean result=false;
        try {
            redisTemplate.opsForValue().set(key,object);
            result = true;
        } catch (Exception e)
        {
            e.printStackTrace();
            result=false;
        }
        return result;

    }
    /**
     * 写入缓存设置时效时间
     * @param key
     * @param value
     * @param expireTime 过期时间
     * @param timeUnit  如下
     * TimeUnit是java.util.concurrent包下面的一个类，表示给定单元粒度的时间段,主要作用时间颗粒度转换
     * TimeUnit.DAYS          //天
     * TimeUnit.HOURS         //小时
     * TimeUnit.MINUTES       //分钟
     * TimeUnit.SECONDS       //秒
     * TimeUnit.MILLISECONDS  //毫秒
     * @return 是否成功
     */
    public boolean set(final String key, Object value, Long expireTime , TimeUnit timeUnit) {
        boolean result = false;
        try {
            //添加之前看看 key 是否已经存在 存在就删除 重新添加
            boolean keyExist = redisTemplate.hasKey(key);
            if (keyExist)
            {
                redisTemplate.delete(key);
            }
            // key,values,过期时间，秒
            redisTemplate.opsForValue().set(key,value,expireTime,timeUnit);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }




    /**
     * 读取缓存
     * @param key  Redis对应的缓存key值
     * @return  返回对应的缓存 value 值
     * 使用final方法的原因主要有两个：
     *
     * 　　(1) 把方法锁定，以防止继承类对其进行更改。
     *
     * 　　(2) 效率，在早期的java版本中，会将final方法转为内嵌调用。但若方法过于庞大，可能在性能上不会有多大提升。因此在最近版本中，不需要final方法进行这些优化了。
     *
     * final方法意味着“最后的、最终的”含义，即此方法不能被重写
     */
    public Object get(final String key) {
        Object result = null;
        try{
            result= (Object)redisTemplate.opsForValue().get(key);
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return result;
    }

    /**
     * 删除指定的 reids
     * @param key 条件为存储key
     * @return true为不超过  false Wie成功
     */
    public  boolean delete(final  String key)
    {
        boolean result=false;
        try{
            redisTemplate.delete(key);
            result=redisTemplate.hasKey(key);  //查询是否还存在 false 不存在 true存在

        }catch (Exception ex){
            ex.fillInStackTrace();
        }
        return  result;
    }
}