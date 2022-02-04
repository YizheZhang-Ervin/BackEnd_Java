package com.ervin.EZSpring.WebEntrance.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/sessioncookie")
@CrossOrigin
public class SessionCookieController {
    @RequestMapping("/add/session")
    public String addSession(HttpServletRequest httpServletRequest,
                             @RequestParam("username")String username) {
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("username",username);
        session.setMaxInactiveInterval(10000);
        return "添加成功";
    }

    @RequestMapping("/show/session")
    public Object showSession(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        Object object = session.getAttribute("username");
        return object;
    }

    @RequestMapping("/add/cookie")
    public String addCookie(HttpServletRequest request, HttpServletResponse response,
                            @RequestParam("username")String username) {
        Cookie cookie = new Cookie("username", username);
        cookie.setPath(request.getContextPath());
        cookie.setMaxAge(80000);
        response.addCookie(cookie);
        return "添加成功";
    }

    @RequestMapping("/show/cookie")
    public String showCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("username")) {
                System.out.println(cookie.getName());
                System.out.println(cookie.getValue());
                return cookie.getValue().toString();
            }
        }
        return "null";
    }
}
