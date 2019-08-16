package com.bxg.community.provider;

import com.alibaba.fastjson.JSON;
import com.bxg.community.dto.AccesstokenDTO;
import com.bxg.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GithubProvider {
    public String getAccessToken(AccesstokenDTO accesstokenDTO) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType , JSON.toJSONString(accesstokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String[] split= response.body().string().split("&");
            String tokenstr=split[0].split("=")[1];

            return tokenstr;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
    public GithubUser getUser(String accessToken) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessToken)
                .build();
        Response response = client.newCall(request).execute();
        String s=response.body().string();

        GithubUser githubUser = JSON.parseObject(s, GithubUser.class);
        return githubUser;
    }
}
