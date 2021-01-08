package com.example.service;

import com.example.bean.Course;
import com.example.bean.Term;
import com.example.dao.CourseDao;
import com.example.dao.TermDao;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    //map用于返回周数
    @Transactional
    public List<Course> selectCourseOfWeek(Integer userId, Integer week, Map<String,Integer> map) throws ParseException {
        Term term = termDao.selectCurTerm();
        if(week==null)week = getNumOfWeek(term,new Date()); //算出第几周
        map.put("week",week);
        //根据termId和周数，用户id查出当周课程
        return dao.selectCourseOfWeek(term.getTermId(),week,userId);
    }

    @Transactional
    public List<Course> getCourseOfNextDay(Integer userId) throws ParseException {
        Term term = termDao.selectCurTerm();
        //算出今天是第几周，周几
        Date date=new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
        date=calendar.getTime();   //这个时间就是日期往后推一天的结果
        //获取周数
        Integer week = getNumOfWeek(term,date);
        //得到明天星期几
        Integer weekDay=null;
        int weekInd = calendar.get(Calendar.DAY_OF_WEEK);
        if(weekInd==1)weekDay=7;    //周日weekInd=1，数据库中为7
        else weekDay=weekInd-1; //周1-6，weekInd=2-7，数据库中为1-6
        //根据termId和周数，用户id查出当周课程
        return dao.selectCourseOfNextDay(term.getTermId(),week,userId,weekDay);
    }

    @Transactional
    public Integer getNumOfWeek(Term term,Date date) throws ParseException {
        Date openTime = term.getOpenTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fromDate = simpleDateFormat.format(openTime);
        String toDate = simpleDateFormat.format(date);
        Date from = simpleDateFormat.parse(fromDate);
        Date to = simpleDateFormat.parse(toDate);
        int days = (int) ((to.getTime() - from.getTime())/(1000 * 60 * 60 * 24));
        return days/7+1;
    }

    @Transactional(readOnly = true)
    public List<Course> selectCurCourseByUserId(Integer userId){
        Term term = termDao.selectCurTerm();
        Integer termId = term.getTermId();
        return dao.selectCurCourseByUserId(userId, termId);
    }

    @Transactional
    public void addCourseToCurTermByUser(Integer userId) {
//        Term term = termDao.selectCurTerm();
//        Integer termId = term.getTermId();
//        dao.addCourseToCurTermByUser();
    }
}
