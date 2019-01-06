package com.linshenkx.quick.demo.interceptor;


import com.alibaba.fastjson.JSONObject;
import com.linshenkx.quick.demo.component.MyProps;
import com.linshenkx.quick.demo.repository.mapper.TUserBaseMapper;
import com.linshenkx.quick.demo.util.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


/**
 * @version V1.0
 * @author: lin_shen
 * @date: 2017/11/7
 * @Description: TODO
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private MyProps myProps;
    @Autowired
    private TUserBaseMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //代替过滤器预防编码问题
        response.setHeader("Content-Type","application/json");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        //设置获取token放行
        String reqUrl=request.getRequestURI();
        log.info(reqUrl);
        for(String url:myProps.getWhiteList()){
            if(reqUrl.contains(url)){
                return true;
            }
        }

        //验证Authorization
        String token = request.getHeader("Authorization");
        if (StringUtils.isEmpty(token)) {
            JSONObject res = new JSONObject();
            res.put("status", 400);
            res.put("msg", "缺少Authorization消息头");
            PrintWriter printWriter = response.getWriter();
            printWriter.print(res.toJSONString());
            printWriter.close();
            return false;
        }
        //验证token
        String userId = JWTUtil.getIdFromJwt(token);
        if (StringUtils.isEmpty(userId)|| null==userMapper.selectByPrimaryKey(userId)) {
            JSONObject res = new JSONObject();
            res.put("status", 400);
            res.put("msg", "token非法");
            PrintWriter printWriter = response.getWriter();
            printWriter.print(res.toJSONString());
            printWriter.close();
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
