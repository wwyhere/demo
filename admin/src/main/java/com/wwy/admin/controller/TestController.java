package com.wwy.admin.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TestController {

    @RequestMapping(value = "/testSession",method = RequestMethod.GET)
    @ResponseBody
    public String testSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        return JSON.toJSONString(session);
    }
}
