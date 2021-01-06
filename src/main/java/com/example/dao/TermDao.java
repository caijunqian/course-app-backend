package com.example.dao;

import com.example.bean.Term;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author 2726868668@qq.com
 * @date 2021/1/5 15:32
 * @desc
 */
@Repository
public interface TermDao {
    @Insert("insert into term values(null,#{years},#{upDown},#{openTime},#{cur})")
    void insert(Term term);

    @Select("select * from term where term_id=#{termId}")
    Term selectById(Integer id);

    @Select("select * from term where cur=1")
    Term selectCurTerm();
}
