package com.linshenkx.quick.demo.controller.test;

import com.linshenkx.quick.demo.dto.TUserBaseRegisterDTO;
import com.linshenkx.quick.demo.dto.TUserBaseUpdateDTO;
import com.linshenkx.quick.demo.repository.mapper.TUserBaseMapper;
import com.linshenkx.quick.demo.repository.model.TUserBase;
import com.linshenkx.quick.demo.util.BeanUtilsPro;
import com.linshenkx.quick.demo.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @version V1.0
 * @author: lin_shen
 * @date: 2018/12/28
 * @Description: TODO
 */
@RestController
@RequestMapping("/test/user")
@Api(tags = "测试-用户", description = "1.0")
public class UserTestController {

    @Autowired
    private TUserBaseMapper tUserBaseMapper;

    @ApiOperation("根据用户名查询用户信息")
    @GetMapping
    public Result find(String userName){
        TUserBase tUserBase=new TUserBase();
        tUserBase.setUserName(userName);
        tUserBase=tUserBaseMapper.selectOne(tUserBase);
        if(tUserBase==null){
            return new Result(false,"此用户不存在");
        }
        return Result.ok(tUserBase);
    }

    @ApiOperation("根据用户名及密码删除用户信息")
    @DeleteMapping
    public Result delete(String userName,String password){
        TUserBase tUserBase=new TUserBase();
        tUserBase.setUserName(userName);
        tUserBase.setPassWord(password);
        tUserBaseMapper.delete(tUserBase);
        return Result.ok();
    }

    @ApiOperation("根据用户名及密码修改用户信息")
    @PutMapping
    public Result update(TUserBaseUpdateDTO tUserBaseUpdateDTO){
        TUserBase tUserBase=new TUserBase();
        tUserBase.setUserName(tUserBaseUpdateDTO.getUserName());
        tUserBase.setPassWord(tUserBaseUpdateDTO.getPassWord());
        tUserBase=tUserBaseMapper.selectOne(tUserBase);
        if(tUserBase==null){
            return new Result(false,"账号或密码错误");
        }
        BeanUtilsPro.copyProperties(tUserBaseUpdateDTO,tUserBase);
        tUserBaseMapper.updateByPrimaryKeySelective(tUserBase);
        return Result.ok();
    }

    @ApiOperation("新建用户")
    @PostMapping
    public Result create(TUserBaseRegisterDTO tUserBaseRegisterDTO){
        if( Strings.isBlank(tUserBaseRegisterDTO.getUserName())||Strings.isBlank(tUserBaseRegisterDTO.getPassWord())){
            return new Result(false,"信息有误");
        }
        //检查用户名是否重复
        TUserBase tUserBase=new TUserBase();
        tUserBase.setUserName(tUserBaseRegisterDTO.getUserName());
        if(tUserBaseMapper.selectOne(tUserBase)!=null){
            return new Result(false,"此用户名已被使用");
        }

        BeanUtilsPro.copyProperties(tUserBaseRegisterDTO,tUserBase);
        tUserBase.setId(UUID.randomUUID().toString());
        tUserBaseMapper.insertSelective(tUserBase);

        return Result.ok();
    }

}
