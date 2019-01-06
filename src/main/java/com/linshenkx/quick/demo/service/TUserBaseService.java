package com.linshenkx.quick.demo.service;

import com.linshenkx.quick.demo.util.Result;
import com.linshenkx.quick.demo.dto.TUserBaseLoginDTO;

/**
 * @version V1.0
 * @author: lin_shen
 * @date: 2018/12/28
 * @Description: TODO
 */

public interface TUserBaseService {
    Result login(TUserBaseLoginDTO tUserBaseDTO, String code);
}
