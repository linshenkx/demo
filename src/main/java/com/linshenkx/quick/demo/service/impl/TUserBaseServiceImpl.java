package com.linshenkx.quick.demo.service.impl;

import com.google.common.collect.Maps;
import com.linshenkx.quick.demo.dto.TUserBaseLoginDTO;
import com.linshenkx.quick.demo.repository.mapper.TUserBaseMapper;
import com.linshenkx.quick.demo.repository.model.TUserBase;
import com.linshenkx.quick.demo.service.AuthService;
import com.linshenkx.quick.demo.service.TUserBaseService;
import com.linshenkx.quick.demo.util.JWTUtil;
import com.linshenkx.quick.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @version V1.0
 * @author: lin_shen
 * @date: 2019/1/6
 * @Description: TODO
 */
@Service
public class TUserBaseServiceImpl implements TUserBaseService {
    @Autowired
    TUserBaseMapper tUserBaseMapper;

    @Autowired
    AuthService authService;

    @Override
    public Result login(TUserBaseLoginDTO tUserBaseDTO, String code) {
        //验证码错误则立即返回
        Result validatedResult=authService.validateImageCode(tUserBaseDTO.getUserName(),code);
        if(!validatedResult.isStatus()){
            return validatedResult;
        }

        //账号不存在或密码错误统一返回
        TUserBase user=new TUserBase();
        user.setUserName(tUserBaseDTO.getUserName());
        user=tUserBaseMapper.selectOne(user);
        if(user==null||!user.getPassWord().equals(tUserBaseDTO.getPassWord())){
            return new Result(false,"您输入的账号或密码有误，请重试！");
        }

        //验证成功返回token
        Map<String,Object> resultMap= Maps.newHashMapWithExpectedSize(1);
        resultMap.put("token", JWTUtil.generateJWT(user.getId()));
        return Result.ok(resultMap);
    }
}
