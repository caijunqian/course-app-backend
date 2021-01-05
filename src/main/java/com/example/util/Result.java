package com.example.util;

import lombok.Data;

/**
 * @author 2726868668@qq.com
 * @date 2021/1/5 13:25
 * @desc
 */
@Data
public class Result {
    private Integer code;
    private String msg;
    private Object data;
}
