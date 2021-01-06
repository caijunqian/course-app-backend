package com.example.bean;

import lombok.Data;

/**
 * @author 2726868668@qq.com
 * @date 2021/1/5 21:50
 * @desc
 */
@Data
public class CourseTime {
    private Integer courseTimeId;
    private Integer courseId;
    private String weekday;
    private String classroom;
    private String startLesson;
    private String endLesson;
}
