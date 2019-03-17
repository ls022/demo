package com.java06.controller;

import com.java06.pojo.Goods;
import com.java06.service.GoodService;
import com.java06.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/good")
public class GoodController {

    @Autowired
    private GoodService goodService;

    @Autowired
    private TypeService typeService;


    @RequestMapping("/getList")
    @ResponseBody
    public Map<String,Object> getPage(Integer offset,Integer limit,Goods goods){
        int page=offset/limit+1;//计算当前页
        return goodService.getList(page,limit,goods);
    }


    @RequestMapping("/updateUpDown")
    @ResponseBody
    public Map<String,Object> updateUpDown(Goods goods){
        return goodService.updateGood(goods);
    }

    @RequestMapping("/deleteGood")
    @ResponseBody
    public Map<String,Object> deleteGood(Goods goods){
        return goodService.deleteGood(goods);
    }


    @RequestMapping("/toUpdate")
    public String toUpdate(HttpServletRequest request,Goods goods){
        if(null!=goods.getId()){
            request.setAttribute("good",goodService.getGoodById(goods.getId()));
        }
        request.setAttribute("tList",typeService.getAll());
        return "goods/good-update";
    }
}
