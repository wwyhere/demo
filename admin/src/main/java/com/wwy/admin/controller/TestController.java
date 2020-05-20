package com.wwy.admin.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Collection;
import java.util.Set;

@Controller
public class TestController {

    @Autowired
    FindByIndexNameSessionRepository<? extends Session> sessions;

    @RequestMapping(value = "/testSession",method = RequestMethod.GET)
    @ResponseBody
    public String testSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        return JSON.toJSONString(session);
    }

//    @RequestMapping("/")
//    public String index(Principal principal, Model model) {
//        Collection<? extends Session> usersSessions = this.sessions.findByPrincipalName(principal.getName()).values();
//        model.addAttribute("sessions", usersSessions);
//        return "index";
//    }
//    // end::findbyusername[]
//
//    @RequestMapping(value = "/sessions/{sessionIdToDelete}", method = RequestMethod.DELETE)
//    public String removeSession(Principal principal, @PathVariable String sessionIdToDelete) {
//        Set<String> usersSessionIds = this.sessions.findByPrincipalName(principal.getName()).keySet();
//        if (usersSessionIds.contains(sessionIdToDelete)) {
//            this.sessions.deleteById(sessionIdToDelete);
//        }
//
//        return "redirect:/";
//    }
}
