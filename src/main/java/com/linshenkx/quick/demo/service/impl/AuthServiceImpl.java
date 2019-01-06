package com.linshenkx.quick.demo.service.impl;


import com.linshenkx.quick.demo.service.AuthService;
import com.linshenkx.quick.demo.util.ImageCode;
import com.linshenkx.quick.demo.util.LocalCacheUtil;
import com.linshenkx.quick.demo.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version V1.0
 * @author: lin_shen
 * @date: 2018/5/13
 * @Description: TODO
 */
@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

    @Value("${imageNumCache}")
    private String imageNumCache;


    @Override
    public void sendImageCode(String id, HttpServletResponse response)  {
        /**
         * 1. 创建图形验证码并输出
         * 2. 保存验证码到本地
         */
        //1
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        ImageCode imageCode = new ImageCode(150,50,4,10);
        try {
            imageCode.write(response.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //2
        log.info("保存验证码: "+imageCode.getCode());
        LocalCacheUtil.hset(imageNumCache,id,imageCode.getCode(),60*10);
    }

    @Override
    public Result validateImageCode(String id, String code) {
        String localCode= (String) LocalCacheUtil.hget(imageNumCache,id);
        log.info("localCode:"+localCode);
        if(localCode==null){
            return new Result(false,"验证码已过期,请重新请求");
        }
        if (!localCode.equalsIgnoreCase(code)){
            return new Result(false,"您输入的验证码有误，请重试");
        }
        return Result.ok();
    }

}
