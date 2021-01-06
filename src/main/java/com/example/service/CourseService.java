package com.example.service;

import com.example.bean.Course;
import com.example.bean.Term;
import com.example.dao.CourseDao;
import com.example.dao.TermDao;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 2726868668@qq.com
 * @date 2021/1/5 22:46
 * @desc
 */
@Service
public class CourseService {
    @Autowired
    CourseDao dao;

    @Autowired
    TermDao termDao;

    public List<Course> selectCourseOfWeek(Integer userId,Integer week) throws ParseException {
        Term term = termDao.selectCurTerm();
        if(week==null){
            //算出第几周
            Date openTime = term.getOpenTime();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String fromDate = simpleDateFormat.format(openTime);
            String toDate = simpleDateFormat.format(new Date());
            Date from = simpleDateFormat.parse(fromDate);
            Date to = simpleDateFormat.parse(toDate);
            int days = (int) ((to.getTime() - from.getTime())/(1000 * 60 * 60 * 24));
            week=days/7+1;
        }
        System.out.println("week is:"+week);
        //根据termId和周数，用户id查出当周课程
        return dao.selectCourseOfWeek(term.getTermId(),week,userId);
    }

}
