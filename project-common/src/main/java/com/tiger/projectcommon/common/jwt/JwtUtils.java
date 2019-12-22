package com.tiger.projectcommon.common.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.stereotype.Component;


import java.util.Date;
import java.util.Map;

/**
 * JWT 公共类
 *
 * @author mytiger
 * @date 2019-12-22 23:57
 */
@Data
@Component  //泛指各种组件，就是说当我们的类不属于各种归类的时候（不属于@Controller、@Services等的时候），我们就可以使用@Component来标注这个类。
public class JwtUtils {


    /**
     * 常量需要全部大写
     */

    /**
     * 生成 jwt token
     *
     * @param id          token ID
     * @param name        token  名称
     * @param map         生成的map键值对
     * @param endDatetime 过期时间
     * @param jwtKey      调用方传过来的私钥
     * @return 返回生成的token
     */
    public String geneJsonWebToken(String id, String name, Map<String, Object> map,
                                   long endDatetime, String jwtKey) {
        try {
            JwtBuilder jwtBuilder = Jwts.builder().setId(id).setSubject(name)
                    .claim("id", id)
                    .claim("name", name)
                    .setIssuedAt(new Date()) //发行时间
                    .setExpiration(new Date(System.currentTimeMillis() + endDatetime)) //过期时间
                    .signWith(SignatureAlgorithm.HS256, jwtKey); //生成token方式、和初始密; //加密方式
            String token = jwtBuilder.setClaims(map).compact();
            return token;

        } catch (Exception EX) {

            EX.getLocalizedMessage();
        }
        return null;
    }

    /**
     * 校验token
     *
     * @param token  token
     * @param jwtkey 生成的初始值密码
     * @return 返回claims对象
     */
    public Claims checkJwt(String token, String jwtkey){
        try {
            final Claims claims = Jwts.parser().
                    setSigningKey(jwtkey).parseClaimsJws(token).getBody();
            return claims;

        } catch (Exception ex){
             ex.getLocalizedMessage();
        }
        return  null;
    }

}
