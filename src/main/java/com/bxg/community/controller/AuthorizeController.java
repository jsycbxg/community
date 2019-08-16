package com.bxg.community.controller;

import com.bxg.community.dto.AccesstokenDTO;
import com.bxg.community.dto.GithubUser;
import com.bxg.community.dto.User;
import com.bxg.community.dto.servrce.UserService;
import com.bxg.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;
    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;
    @Autowired
    private UserService userService;

    @GetMapping("/callback")
    public String callback(@RequestParam("code")String code, @RequestParam("state")String state, HttpServletRequest request, HttpServletResponse response){
        AccesstokenDTO accesstokenDTO = new AccesstokenDTO();
        accesstokenDTO.setCode(code);
        accesstokenDTO.setState(state);
        accesstokenDTO.setRedirect_url(redirectUri);
        accesstokenDTO.setClient_id(clientId);
        accesstokenDTO.setClient_secret(clientSecret);
        System.out.println(redirectUri);
        System.out.println(clientId);
        System.out.println(clientSecret);
        String token= githubProvider.getAccessToken(accesstokenDTO);
        try {
            GithubUser user=githubProvider.getUser(token);
            System.out.println(user.getName());
            if(user!=null){
                User user1=new User();
                String token1=UUID.randomUUID().toString();
                user1.setToken(token1);
                user1.setName(user.getName());
                user1.setAccountId(String.valueOf(user.getId()));
                user1.setGmtCreate(System.currentTimeMillis());
                user1.setGmtModified(user1.getGmtCreate());
                userService.sava(user1);
                response.addCookie(new Cookie("token",token1));
                return "redirect:/";
            }else {
                return "redirect:/";
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return "index";
    }
}
