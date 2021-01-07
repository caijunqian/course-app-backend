package com.example.bean;


import lombok.Data;

import java.util.Date;

/**
 * @author 2726868668@qq.com
 * @date 2021/1/7 17:45
 * @desc
 */
@Data
public class Item {
    private Integer itemId;
    private String name;
    private String detail;
    private Date endTime;
    private Integer canDelete;
    private Integer isFinished;
    private Integer userId;
}
