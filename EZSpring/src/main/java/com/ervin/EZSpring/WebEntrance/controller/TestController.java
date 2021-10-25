package com.ervin.EZSpring.WebEntrance.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {

    @RequestMapping(value="/hello",params={"name!=user","passord"},headers={"Accept-Encoding=gzip,deflate"},method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    // 请求转发1
    @RequestMapping(value="/forward",method=RequestMethod.GET)
    public ModelAndView testForward(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","xx");
        // mv.setViewName("index");
        // mv.setViewName("forward:index.html?msg=xx");
        mv.setViewName("forward:index.html");
        return mv;
    }

    // 请求转发2
    @RequestMapping(value="/forward2",method=RequestMethod.GET)
    public String testForward2(HttpServletRequest request, HttpSession sa){
        request.setAttribute("msg","xx");
        sa.setAttribute("msg","xx");
        // return "forward:index.html";  // 会从根目录查找
        return "index";
    }

    // 重定向
    @RequestMapping(value="/redirect",method=RequestMethod.GET)
    public ModelAndView testRedirect(RedirectAttributes ra){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","xx");
        ra.addAttribute("msg","xx"); // 可设置中文参数
        // mv.setViewName("redirect:index.html?msg=xx");
        mv.setViewName("redirect:index.html");
        return mv;
    }

    // 重定向2
    @RequestMapping(value="/redirect2",method=RequestMethod.GET)
    public String testRedirect2(){
        return "redirect:/index.html";
    }

    // 重定向3
    @RequestMapping(value="/redirect3",method=RequestMethod.GET)
    public String testRedirect3(Model model){
        model.addAttribute("msg","xx");
        return "index";
    }

    // 重定向4
    @RequestMapping(value="/redirect4",method=RequestMethod.GET)
    public String testRedirect4(ModelMap mm){
        mm.addAttribute("msg","xx");
        return "index";
    }

    // 重定向5
    @RequestMapping(value="/redirect5",method=RequestMethod.GET)
    public String testRedirect5(Map map){
        map.put("msg","xx");
        return "index";
    }

    // 上传文件
    @GetMapping("/upload")
    public String upload() {
        return "upload";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }

        String fileName = file.getOriginalFilename();
        String filePath = "E://";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            return "上传成功";
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return "上传失败！";
    }

    // 方法1: 接收日期类型
    // 方法2: 实现Converter
    @RequestMapping("/date")
    @ResponseBody
    public String getDate(@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date birthdate){
        return "success";
    }

    // 集合传值
    @RequestMapping("/collection")
    @ResponseBody
    public String getCollection(List<Integer> list){
        // 前端可input写 name=list[0]
        System.out.println(list);
        return "success";
    }
}
