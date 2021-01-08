package com.example.controller;

import com.example.bean.Course;
import com.example.service.CourseService;
import com.example.util.Result;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            Map<String,Integer> map = new HashMap<String,Integer>();
            List<Course> courses = service.selectCourseOfWeek(userId,week,map);
            if(courses==null || courses.size()==0){
                result.setCode(204);
                result.setMsg(map.get("week").toString());
            }
            else{
                result.setCode(200);
                result.setMsg(map.get("week").toString());
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

    @GetMapping(value = "/getCourseOfNextDay/{userId}",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getCourseOfNextDay(@PathVariable("userId") Integer userId) {
        Result result = new Result();
        try {
            List<Course> courseOfNextDay = service.getCourseOfNextDay(userId);
            if(courseOfNextDay==null || courseOfNextDay.size()==0){
                result.setCode(204);
                result.setMsg("没有课程存在");
            }
            else {
                result.setCode(200);
                result.setData(courseOfNextDay);
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(500);
            result.setMsg("服务器繁忙！");
        }
        Gson gson = new Gson();
        return gson.toJson(result);
    }

    @GetMapping("/courses/{userId}")
    public String getCourseByUser(@PathVariable("userId")Integer userId, Model model){
        List<Course> courses = service.selectCurCourseByUserId(userId);
        model.addAttribute("courses",courses);
        model.addAttribute("userId",userId);
        return "pages/courses";
    }

    @GetMapping("/toAddCourse/{userId}")
    public String toAddCourse(@PathVariable("userId")Integer userId){
        return "pages/addCourse";
    }

    @PostMapping(value = "/addCourse",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String addCourseToCurTermByUser(@RequestBody Course course){
        service.addCourseToCurTermByUser(course);
        new Result();
        Gson gson = new Gson();
        return gson.toJson(new Result());
    }
}
