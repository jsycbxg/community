package com.bxg.community.controller;

import com.bxg.community.dto.AccesstokenDTO;
import com.bxg.community.dto.GithubUser;
import com.bxg.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;
    @Value("github.client.id")
    private String clientId;
    @Value("github.client.secret")
    private String clientSecret;
    @Value("github.redirect.uri")
    private String redirectUri;

    @GetMapping("/callback")
    public String callback(@RequestParam("code")String code,@RequestParam("state")String state){
        AccesstokenDTO accesstokenDTO = new AccesstokenDTO();
        accesstokenDTO.setCode(code);
        accesstokenDTO.setState(state);
        accesstokenDTO.setRedirect_url(redirectUri);
        accesstokenDTO.setClient_id(clientId);
        accesstokenDTO.setClient_secret(clientSecret);

        String token= githubProvider.getAccessToken(accesstokenDTO);
        try {
            GithubUser user=githubProvider.getUser(token);
            System.out.println(user.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }


        return "index";
    }
}
