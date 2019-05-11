package com.funtl.myshop.service.user.consumer.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.funtl.myshop.commons.domain.User;
import com.funtl.myshop.service.redis.api.RedisService;
import com.funtl.myshop.service.user.api.Userservice;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @Reference(version = "${services.versions.user.v1}")
    private Userservice userservice;

    @Reference(version = "${services.versions.redis.v1}")
    private RedisService redisService;

    @ResponseBody
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public List<User> getAll(){
        redisService.set("zzz","value");
        redisService.get("user");
        return userservice.selectAll();
    }
    @ResponseBody
    @RequestMapping(value = "hi", method = RequestMethod.GET)
    public String getHello(){
        return "Hello world!";
    }

    @RequestMapping(value = "name", method = RequestMethod.GET)
    public String getLoginName(Model model){
        System.out.println(userservice.selectAll().get(0).toString());
        model.addAttribute("title","标题");
        model.addAttribute("createdTime","2018nian");
        return "user/list";
    }

    @RequestMapping(value = "page", method = RequestMethod.GET)
    public String page(Model model){
        System.out.println("page==========================================");
        PageInfo<User> pageInfo = userservice.page(2,2);
        System.out.println(pageInfo.getList().size());
        System.out.println(pageInfo.getList().get(0).toString());
        return "user/abc";
    }


    @RequestMapping("abc")
    public String ll(){
        return "user/abc";
    }
}
