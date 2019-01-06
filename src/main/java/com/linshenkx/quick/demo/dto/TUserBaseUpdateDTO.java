package com.linshenkx.quick.demo.dto;

import lombok.Data;

/**
 * @version V1.0
 * @author: lin_shen
 * @date: 2019/1/6
 * @Description: TODO
 */
@Data
public class TUserBaseUpdateDTO {
    /**
     * 登录账号
     */
    private String userName;

    /**
     * 登录密码
     */
    private String passWord;

    private String extReserve;

}
