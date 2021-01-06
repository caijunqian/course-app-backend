package com.example.controller;

import com.example.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author 2726868668@qq.com
 * @date 2021/1/5 21:38
 * @desc
 */
@Controller
public class TermController {
    @Autowired
    TermService service;
}
