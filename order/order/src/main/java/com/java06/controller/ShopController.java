package com.java06.controller;

import com.java06.pojo.Goods;
import com.java06.pojo.Orders;
import com.java06.service.GoodService;
import com.java06.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@RequestMapping("/shop")
@Controller
public class ShopController {

    @Autowired
    private GoodService goodService;

    @Autowired
    private ShopService shopService;

    @RequestMapping("/index")
    public String toIndex(){
        return "order/index";
    }

    @RequestMapping("/getHot")
    @ResponseBody
    public List<Goods> getPage(Integer page, Integer pagesize){
        return goodService.getHot(page,pagesize);
    }

    @RequestMapping("/menu")
    public String toMenu(){
        return "order/menu";
    }

    @RequestMapping("/shop")
    public String toShop(){
        return "order/shop";
    }

    @RequestMapping("getAllList")
    @ResponseBody
    public Map<String,Object> getAllList(){
        return shopService.getAllList();
    }

    @RequestMapping("/doShop")
    @ResponseBody
    public Map<String,Object> doShop(Orders orders,String[] gids,String[] cs){
        return shopService.doShop(orders,gids,cs);
    }
}
