package com.example.bean;

import lombok.Data;

import java.util.List;

/**
 * @author 2726868668@qq.com
 * @date 2021/1/5 21:42
 * @desc
 */
@Data
public class Course {
    private Integer courseId;
    private Integer userId;
    private Integer termId;
    private String courseName;
    private Integer startWeek;
    private Integer endWeek;
    //以下是course_time表的数据，用作安卓接口的DTO传递数据
    private Integer courseTimeId;
    private Integer weekday;
    private String classroom;
    private String startLesson;
    private String endLesson;
    //以下是后台管理时需要用到的一对多
    List<CourseTime> courseTimes;
}
