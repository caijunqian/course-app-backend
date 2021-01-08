package com.example.controller;

import com.example.bean.Info;
import com.example.exception.InfoException;
import com.example.service.InfoService;
import com.example.util.Result;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 2726868668@qq.com
 * @date 2021/1/5 10:41
 * @desc
 */
@Controller
@RequestMapping("/info")
public class InfoController {
    @Autowired
    InfoService service;

    @PostMapping(value = "/verify",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String verify(@RequestParam("num") String num,@RequestParam("pwd")String pwd){
        Info info = null;
        Result result = new Result();
        try {
            info = service.verify(num,pwd);
            System.out.println(info);
            result.setCode(200);
            result.setData(info);
        }catch (InfoException e){
            result.setCode(400);
            result.setMsg(e.getMessage());
        }catch (Exception e){
            result.setCode(500);
            result.setMsg("服务器错误");
        }
        Gson gson = new Gson();
        return gson.toJson(result);
    }

    @PutMapping(value = "/updatePwd",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String updatePwd(Integer userId,String oldPwd,String newPwd){
        Result result = new Result();
        try {
            service.updatePwd(userId,oldPwd,newPwd);
            result.setCode(200);
        }catch (InfoException e){
            result.setCode(400);
            result.setMsg(e.getMessage());
        }catch (Exception e){
            result.setCode(500);
            result.setMsg("服务器错误");
        }
        Gson gson = new Gson();
        return gson.toJson(result);
    }

    @GetMapping("/toInfos")
    public String toInfos(Model model){
        List<Info> infos = service.selectAll();
        model.addAttribute("infos",infos);
        return "pages/infos";
    }

    @PostMapping("/addInfo")
    public String addInfo(Info info){
        System.out.println(info);
        service.insert(info);
        return "redirect:/info/toInfos";
    }
}
