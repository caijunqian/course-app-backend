package com.example.controller;

import com.example.bean.Course;
import com.example.bean.Item;
import com.example.service.ItemService;
import com.example.util.Result;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 2726868668@qq.com
 * @date 2021/1/7 18:38
 * @desc
 */
@Controller
public class ItemController {
    @Autowired
    ItemService service;

    @PostMapping(value = "/item",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String insertItem(Item item){
        Result result = new Result();
        try {
            service.insertItem(item);
            result.setCode(200);
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(500);
            result.setMsg("服务器繁忙，添加错误。");
        }
        Gson gson = new Gson();
        return gson.toJson(result);
    }

    @DeleteMapping(value = "/item/{itemId}", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String deleteItem(@PathVariable("itemId")Integer itemId){
        Result result = new Result();
        try {
            service.deleteItem(itemId);
            result.setCode(200);
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(500);
            result.setMsg("服务器繁忙,删除发生错误。");
        }
        Gson gson = new Gson();
        return gson.toJson(result);
    }

    @GetMapping(value = "/items/{userId}/{isFinished}", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String selectItems(@PathVariable("isFinished")Integer isFinished,@PathVariable("userId")Integer userId){
        Result result = new Result();
        try {
            List<Item> items;
            if(isFinished==1||isFinished==0) {
                items = service.selectItems(userId, isFinished);
                result.setCode(200);
                result.setData(items);
                if(items==null || items.size()==0){
                    result.setCode(204);
                    result.setMsg("没有内容");
                }else{
                    result.setCode(200);
                    result.setData(items);
                }
            }
            else{
                result.setCode(400);
                result.setMsg("参数错误，查询失败。");
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(500);
            result.setMsg("服务器繁忙,查询失败。");
        }
        Gson gson = new Gson();
        return gson.toJson(result);
    }

    @GetMapping(value = "/expiringItems/{userId}", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String selectDeadlineItems(@PathVariable("userId")Integer userId){
        Result result = new Result();
        try {
            List<Item> items;
            items = service.selectExpiringItems(userId);
            if(items==null || items.size()==0){
                result.setCode(204);
                result.setMsg("没有即将截止的事件");
            }
            else{
                result.setCode(200);
                result.setData(items);
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(500);
            result.setMsg("服务器繁忙,查询失败。");
        }
        Gson gson = new Gson();
        return gson.toJson(result);
    }

    //以上是接口，以下是后台管理需要用的
    @RequestMapping("/items/{userId}")
    public String getCourseByUser(@PathVariable("userId")Integer userId, Model model){
        List<Item> items = service.selectAllItems(userId);
        model.addAttribute("items",items);
        model.addAttribute("userId",userId);
        return "pages/items";
    }

    @PostMapping("/addItem")
    public String addCourseToCurTermByUser(Item item){
        item.setCanDelete(0);
        item.setIsFinished(0);
        service.addItemByUser(item);
        return "redirect:/items/"+item.getUserId();
    }
}
