package com.example.service;

import com.example.bean.Info;
import com.example.dao.InfoDao;
import com.example.exception.InfoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.TreeMap;

/**
 * @author 2726868668@qq.com
 * @date 2021/1/5 10:12
 * @desc
 */
@Service
public class InfoService {
    @Autowired
    InfoDao dao;

    @Transactional(readOnly = true)
    public Info verify(String num,String pwd){
        Info info = dao.selectByNum(num);
        if(info==null)throw new InfoException("用户不存在");
        if(!info.getPwd().equals(pwd))throw new InfoException("密码错误");
        return info;
    }

    @Transactional(rollbackFor = java.lang.Exception.class)
    public void insert(Info info){
        dao.insert(info);
    }

    @Transactional(rollbackFor = java.lang.Exception.class)
    public void updatePwd(Integer userId,String oldPwd,String newPwd){
        Info info = dao.selectByUserId(userId);
        if(info==null)throw new InfoException("用户不存在");
        if(!info.getPwd().equals(oldPwd))throw new InfoException("旧密码错误");
        info.setPwd(newPwd);
        dao.update(info);
    }
    @Transactional(readOnly = true)
    public List<Info> selectAll(){
        return dao.selectAll();
    }
}
