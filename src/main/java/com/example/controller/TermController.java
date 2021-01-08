package com.example.controller;

import com.example.bean.Term;
import com.example.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author 2726868668@qq.com
 * @date 2021/1/5 21:38
 * @desc
 */
@Controller
public class TermController {
    @Autowired
    TermService service;


    @GetMapping("/toTerm")
    public String toTerm(Model model){
        List<Term> terms = service.selectAll();
        model.addAttribute("terms",terms);
        return "pages/terms";
    }
    @PostMapping("/term")
    public String addTerm(Term term){
        System.out.println(term);
        service.insert(term);
        return "redirect:/toTerm";
    }
}
