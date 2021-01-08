package com.example.dao;

import com.example.bean.Course;
import com.example.bean.CourseTime;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
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

    List<Course> selectCourseOfNextDay(Integer termId, Integer week,Integer userId,Integer weekDay);

    List<Course> selectCurCourseByUserId(Integer userId,Integer termId);

    @Insert("insert into course values(null,#{userId},#{termId},#{courseName},#{startWeek},#{endWeek})")
    @Options(useGeneratedKeys = true, keyProperty = "courseId", keyColumn = "course_id")
    void insertCourse(Course course);

    void insertCourseTimes(List<CourseTime> courseTimes);
}
