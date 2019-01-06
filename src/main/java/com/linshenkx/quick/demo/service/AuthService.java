package com.linshenkx.quick.demo.service;


import com.linshenkx.quick.demo.util.Result;

import javax.servlet.http.HttpServletResponse;

/**
 * @version V1.0
 * @author: lin_shen
 * @date: 2018/5/13
 * @Description: TODO
 */

public interface AuthService {

    void sendImageCode(String id, HttpServletResponse response);

    Result validateImageCode(String id, String code);

}
