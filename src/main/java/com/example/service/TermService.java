package com.example.service;

import com.example.bean.Term;
import com.example.dao.TermDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @author 2726868668@qq.com
 * @date 2021/1/5 16:15
 * @desc
 */
@Service
public class TermService {
    @Autowired
    TermDao dao;
    @Transactional
    public void insert(Term term){
        dao.updateCurTerm();//把当前学期cur置0
        dao.insert(term);
    }

    @Transactional(readOnly = true)
    public Term selectById(Integer id){
        return dao.selectById(id);
    }

    @Transactional(readOnly = true)
    public List<Term> selectAll(){
        return dao.selectAll();
    }
}
