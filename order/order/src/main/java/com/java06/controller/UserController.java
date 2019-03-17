package com.java06.controller;

import com.java06.pojo.Goods;
import com.java06.pojo.Users;
import com.java06.service.GoodService;
import com.java06.service.UserService;
import com.java06.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private GoodService goodService;


    @RequestMapping("/login")
    @ResponseBody
    public Map<String,Object> doLogin(Users users, HttpSession session){
        /*声明map对象*/
        Map<String,Object> map=new HashMap<>();





        users=userService.doLogin(users);
        if(users!=null){
            map.put("status",1);
            session.setAttribute("loginUser",users);
        }else{
            map.put("status",0);
        }
        return map;
    }

    @RequestMapping("/toList")
    public String toList(HttpServletRequest request){
        List<Goods> list=goodService.getPage();//从Service层获取数据
        request.setAttribute("gList",list);//放入request作用域
//        return "index/main";//跳转页面

        return "goods/goods-list";
    }
}
