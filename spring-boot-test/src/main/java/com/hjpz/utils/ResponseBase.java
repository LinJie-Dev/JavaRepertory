package com.hjpz.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 统一返回实体
 * @param <T> 泛型实体
 */
@ApiModel(description = "统一返回实体")
public class ResponseBase<T> implements Serializable {
    @ApiModelProperty(value = "返回信息(成功或失败)")
    private String message;
    @ApiModelProperty(value = "返回参数")
    private T data;
    @ApiModelProperty(value = "返回状态码(成功：200，失败：400)")
    private Integer code;

    public static <T> ResponseBase<T> success(T data) {
        ResponseBase response = new ResponseBase<T>();
        response.setCode(200);
        response.setMessage("操作成功");
        response.setData(data);
        return response;
    }
    public static <T> ResponseBase<T> error(String message) {
        ResponseBase<T> response = new ResponseBase<>();
        response.setCode(400);
        response.setMessage(message);
        return response;
    }

    public static <T> ResponseBase<T> fail(String message) {
        ResponseBase<T> response = new ResponseBase<>();
        response.setCode(400);
        response.setMessage(message);
        return response;
    }

    public static <T> ResponseBase<T> error(Integer code, String message) {
        ResponseBase<T> response = new ResponseBase<>();
        response.setCode(code);
        response.setMessage(message);
        return response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
