package com.linshenkx.quick.demo.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @version V1.0
 * @author: lin_shen
 * @date: 2017/11/5
 * @Description: TODO
 */

public class JWTUtil {

    /**
     * 签名密钥
     */
    private static final String key="hdcpptd123.";

    /**
     * JWT加密的简单实现,直接传入一个String的value即可,默认为id键
     * @param id
     * @return
     */
    public static String generateJWT(String id){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("id",id);
        return generateJWT(map);
    }

    /**
     * JWT解密的简单实现,直接按照id键取值
     * @param token
     * @return
     */
    public static String getIdFromJwt(String token){
        Map<String,Object> map=getClaimsFromJwt(token);
        if( map==null||map.get("id")==null){
            return null;
        }else {
            return (String)map.get("id");
        }
    }

    /**
     * JWT加密的基础实现,需传入Map
     * @param claims Map对象,不应含敏感内容
     * @return
     */
    public static String generateJWT(Map<String,Object> claims){
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256,key)
                .compact();
    }

    /**
     * JWT解密的基础实现,返回对象可直接用Map接收
     * @param token
     * @return
     */
    public static Claims getClaimsFromJwt(String token){
        //Key key= MacProvider.generateKey();
        Claims claims;
        try{
            claims=Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            claims=null;
        }
        return claims;
    }
}
