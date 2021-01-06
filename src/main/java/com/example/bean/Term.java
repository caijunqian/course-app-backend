package com.example.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author 2726868668@qq.com
 * @date 2021/1/5 15:00
 * @desc
 */
@Data
public class Term {
    private Integer termId;
    private String years;
    private Integer upDown;
    private Date openTime;
    private Integer cur;
}
