package com.example.dao;

import com.example.bean.Term;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 2726868668@qq.com
 * @date 2021/1/5 15:32
 * @desc
 */
@Repository
public interface TermDao {
    @Insert("insert into term values(null,#{years},#{upDown},#{openTime},1)")
    void insert(Term term);

    @Select("select * from term where term_id=#{termId}")
    Term selectById(Integer id);

    @Select("select * from term where cur=1")
    Term selectCurTerm();

    //查询最近的20个学期，并且按开学时间降序
    @Select("select * from term order by open_time desc")
    List<Term> selectAll();

    @Update("update term set cur=0 where cur=1")
    void updateCurTerm();
}
