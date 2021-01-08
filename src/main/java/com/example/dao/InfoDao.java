package com.example.dao;

import com.example.bean.Info;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 2726868668@qq.com
 * @date 2021/1/5 10:04
 * @desc
 */
@Repository
public interface InfoDao {

    @Insert("insert into info values(null,#{num},123456,#{name},#{grade},#{classes})")
    void insert(Info info);

    @Update("update info set num=#{num},pwd=#{pwd},name=#{name},grade=#{grade},classes=#{classes} where user_id=#{userId}")
    void update(Info info);

    @Select("select * from info where user_id=#{param1}")
    Info selectByUserId(Integer id);

    @Select("select * from info where num=#{param1}")
    Info selectByNum(String num);

    @Select("select * from info")
    List<Info> selectAll();
}
