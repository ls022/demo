package com.java06.controller;

import com.java06.utils.ImageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/upload")
public class UploadController {

    @RequestMapping("/uploadImg")
    @ResponseBody
    public Map<String,Object> uploadImg(HttpServletRequest request, @RequestParam("file") MultipartFile[] files){
        Map<String,Object> map=new HashMap<>();
        /*拿到目录的文件路径，例如：C://...tomcat/web*/
        String path=request.getServletContext().getRealPath("/static/upload")+"/";
        String fileName= ImageUtil.uploadImg(path,files);
        if(fileName!=null){
            map.put("fileName",fileName);
            map.put("status",1);
        }
        return map;
    }
}
