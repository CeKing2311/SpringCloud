package com.ceking.springcloud.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ceking
 * @desc
 * @date 2021/1/23 13:38
 */
@Data
@NoArgsConstructor
public class CommonResult<T> {
    private  Integer code;
    private  String message;
    private  T data;

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
