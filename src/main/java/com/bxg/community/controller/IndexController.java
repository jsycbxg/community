package com.bxg.community.controller;

import com.bxg.community.dto.User;
import com.bxg.community.dto.repository.UserRepository;
import com.bxg.community.dto.servrce.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @Autowired
    private UserService service;
    @GetMapping("/")
    public String index(HttpServletRequest request){


        for (Cookie cookie : request.getCookies()) {
            if(cookie.getName().equals("token")){
                String token =cookie.getValue();
                User user=service.findByToken(token);
                if(user!=null){
                    request.getSession().setAttribute("user",user.getName());
                }
                break;
            }
        }

        return "index";
    }

}
