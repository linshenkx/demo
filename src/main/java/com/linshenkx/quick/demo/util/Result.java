package com.linshenkx.quick.demo.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

/**
 * Created on 2017/11/7.
 *
 * @author zlf
 * @since 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    private boolean status;

    private String message;

    private Object data;

    public Result(boolean status ,String message){
        this.status=status;
        this.message=message;
    }

    @Override
    public String toString(){
        JSONObject jsonObject=new JSONObject();
        jsonObject. put("status", status).put("message", message).put("data", data);
        return jsonObject.toString();
    }

    public static Result ok(){
        return new Result(true,"执行成功");
    }
    public static Result ok(String message){
        return new Result(true,message);
    }
    public static Result ok(String message,Object data){
        return new Result(true,message,data);
    }
    public static Result ok(Object data){
        return new Result(true,"执行成功",data);
    }




}
