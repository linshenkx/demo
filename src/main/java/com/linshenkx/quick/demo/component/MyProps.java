package com.linshenkx.quick.demo.component;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @version V1.0
 * @author: lin_shen
 * @date: 2018/5/9
 * @Description: @Component
 * 接收application.yml中的myProps下面的属性
 */
@Component
@ConfigurationProperties(prefix="my-props")
@Data
public class MyProps {
    private List<String> whiteList = new ArrayList<>();

}
