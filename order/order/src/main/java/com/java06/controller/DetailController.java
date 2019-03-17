package com.java06.controller;

import com.java06.pojo.Details;
import com.java06.pojo.Goods;
import com.java06.pojo.Orders;
import com.java06.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RequestMapping("/detail")
@Controller
public class DetailController {

    @Autowired
    private DetailService detailService;

    @RequestMapping("/toList")
    public String toList(){
        return "details/details-list";
    }

    @RequestMapping("/getList")
    @ResponseBody
    public Map<String,Object> getPage(Integer offset, Integer limit, Orders orders){
        int page=offset/limit+1;//计算当前页
        return detailService.getList(page,limit,orders);
    }

    @RequestMapping("/getAll")
    @ResponseBody
    public Map<String,Object> getAll(Integer offset, Integer limit, Details details){
        int page=offset/limit+1;//计算当前页
        return detailService.getAll(page,limit,details);
    }

    @RequestMapping("/getDetails")
    public String getDetails(HttpServletRequest request,Integer id){
        request.setAttribute("gid",id);
        return "details/details-all";
    }
}
