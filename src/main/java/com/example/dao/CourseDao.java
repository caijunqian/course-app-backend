package com.example.dao;

import com.example.bean.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 2726868668@qq.com
 * @date 2021/1/5 22:26
 * @desc
 */
@Repository
public interface CourseDao {
    List<Course> selectCourseOfWeek(Integer termId, Integer week,Integer userId);
}
