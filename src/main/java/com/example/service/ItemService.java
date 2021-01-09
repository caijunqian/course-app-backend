package com.example.service;

import com.example.bean.Item;
import com.example.dao.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author 2726868668@qq.com
 * @date 2021/1/7 18:33
 * @desc
 */
@Service
public class ItemService {
    @Autowired
    ItemDao dao;
    @Transactional
    public void insertItem(Item item){
        dao.insert(item);
    }

    @Transactional
    public void deleteItem(Integer itemId){
        dao.delete(itemId);
    }

    @Transactional(readOnly = true)
    public List<Item> selectItems(Integer userId,Integer isFinished){
        if(isFinished==1)return dao.selectFinishedByUserId(userId);
        return dao.selectUnfinishedByUserId(userId);

    }
    @Transactional(readOnly = true)
    public List<Item> selectExpiringItems(Integer userId){
        Date date=new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
        date=calendar.getTime();   //这个时间就是日期往后推一天的结果
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = simpleDateFormat.format(date);
        return dao.selectExpiringByUserId(userId,dateStr);
    }

    @Transactional(readOnly = true)
    public List<Item> selectAllItems(Integer userId) {
        return dao.selectAllByUserId(userId);
    }

    @Transactional
    public void addItemByUser(Item item) {
        dao.insert(item);
    }
}
