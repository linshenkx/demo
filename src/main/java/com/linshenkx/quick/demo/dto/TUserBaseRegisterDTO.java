package com.linshenkx.quick.demo.dto;

import lombok.Data;

import javax.persistence.Column;

/**
 * @version V1.0
 * @author: lin_shen
 * @date: 2019/1/6
 * @Description: TODO
 */
@Data
public class TUserBaseRegisterDTO {

    /**
     * 登录账号
     */
    @Column(name = "`USER_NAME`")
    private String userName;

    /**
     * 登录密码
     */
    @Column(name = "`PASS_WORD`")
    private String passWord;


}
