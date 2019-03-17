package com.java06.controller;

import com.java06.pojo.Goods;
import com.java06.pojo.Types;
import com.java06.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/type")
public class TypeController {


    @Autowired
    private TypeService typeService;

    @RequestMapping("/toList")
    public String toList(){
        return "types/type-list";
    }

    @RequestMapping("/getList")
    @ResponseBody
    public Map<String,Object> getPage(Integer offset, Integer limit, Types types){
        int page=offset/limit+1;//计算当前页
        return typeService.getPage(page,limit,types);
    }


    @RequestMapping("/toUpdate")
    public String toUpdate(HttpServletRequest request,Types types){
        if(types.getId()!=null){
            types=typeService.getInfoById(types.getId());
            request.setAttribute("ttt",types);
        }
        return "types/type-update";
    }

    @RequestMapping("/doUpdate")
    @ResponseBody
    public Map<String,Object> doUpdate(Types types){
        return typeService.updateInfo(types);
    }


    @RequestMapping("/deleteType")
    @ResponseBody
    public Map<String,Object> deleteInfo(Types types){
        return typeService.deleteInfo(types.getId());
    }
}
