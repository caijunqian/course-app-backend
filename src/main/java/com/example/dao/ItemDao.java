package com.example.dao;

import com.example.bean.Item;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author 2726868668@qq.com
 * @date 2021/1/7 18:14
 * @desc
 */
@Repository
public interface ItemDao {
    /*默认插入的是未完成的*/
    @Insert("insert into item values(null,#{name},#{detail},#{endTime},#{canDelete},0,#{userId})")
    void insert(Item item);

    @Delete("delete from item where item_id=#{param1}")
    void delete(Integer itemId);

    /*查出最近20个未完成的Item*/
    @Select("select * from item where user_id=#{param1} and is_finished=0 order by end_time limit 20")
    List<Item> selectUnfinishedByUserId(Integer userId);

    /*查出最近20个已完成的Item*/
    @Select("select * from item where user_id=#{param1} and is_finished=1 order by end_time desc limit 20")
    List<Item> selectFinishedByUserId(Integer userId);

    /*查询date到期且未完成的item*/
    @Select("select * from item where user_id=#{param1} and is_finished=0 and end_time=#{param2}")
    List<Item> selectExpiringByUserId(Integer userId, String dateStr);

    @Select("select * from item where user_id=#{param1}")
    List<Item> selectAllByUserId(Integer userId);

    @Update("update item set is_finished=#{param2} where item_id = #{param1}")
    void markFinished(Integer itemId,Integer isFinished);
}
