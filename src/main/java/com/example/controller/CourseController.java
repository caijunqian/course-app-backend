package com.example.controller;

import com.example.bean.Course;
import com.example.service.CourseService;
import com.example.util.Result;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.List;

/**
 * @author 2726868668@qq.com
 * @date 2021/1/6 19:41
 * @desc
 */
@Controller
public class CourseController {
    @Autowired
    CourseService service;

    @GetMapping(value = {"/getCourseOfWeek/{userId}","/getCourseOfWeek/{userId}/{week}"},produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getCourseOfWeek(@PathVariable("userId") Integer userId,@PathVariable(value = "week",required = false) Integer week) {
        Result result = new Result();
        try {
            List<Course> courses = service.selectCourseOfWeek(userId,week);
            if(courses==null || courses.size()==0){
                result.setCode(204);
                result.setMsg("没有课程存在");
            }
            else{
                result.setCode(200);
                result.setData(courses);
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(500);
            result.setMsg("服务器繁忙！");
        }
        Gson gson = new Gson();
        return gson.toJson(result);
    }
}
