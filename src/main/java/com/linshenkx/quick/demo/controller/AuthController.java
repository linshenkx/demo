package com.linshenkx.quick.demo.controller;


import com.linshenkx.quick.demo.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @version V1.0
 * @author: lin_shen
 * @date: 2018/5/13
 */
@Api(tags = "认证相关", description = "1.0")
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @GetMapping("/sendImageCode")
    @ApiOperation("获取图形验证码")
    public void sendImageCode(@RequestParam String username, HttpServletResponse response)  {
         authService.sendImageCode(username,response);
    }

}
