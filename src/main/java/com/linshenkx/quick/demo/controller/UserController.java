package com.linshenkx.quick.demo.controller;

import com.linshenkx.quick.demo.dto.TUserBaseLoginDTO;
import com.linshenkx.quick.demo.service.TUserBaseService;
import com.linshenkx.quick.demo.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version V1.0
 * @author: lin_shen
 * @date: 2018/12/28
 * @Description: TODO
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户信息", description = "1.0")
public class UserController {
    @Autowired
    private TUserBaseService userService;

    @ApiOperation("用户登录，获取token")
    @PostMapping("/login")
    public Result login(TUserBaseLoginDTO tUserBaseDTO, String picCode){
        return userService.login( tUserBaseDTO, picCode);
    }

}
