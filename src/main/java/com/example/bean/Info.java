package com.example.bean;

import lombok.Data;

/**
 * @author 2726868668@qq.com
 * @date 2021/1/5 10:01
 * @desc
 */
@Data
public class Info {
    private Integer userId;
    private String num;     //学号
    private String pwd;     //密码
    private String name;    //姓名
    private String grade;   //年级
    private String classes; //班级
}
