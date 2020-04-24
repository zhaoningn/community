package com.zhaoning.community.provider;

import com.alibaba.fastjson.JSON;
import com.zhaoning.community.dto.AccessTokenDTO;
import com.zhaoning.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author zhaoning
 * @date 2020/4/24 - 14:46
 */
@Component
public class GithubProvider {

    public String getAccessToker(AccessTokenDTO accessTokenDTO){

        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();

            RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
            Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                String string = response.body().string();
                String[] split =string.split("&");
                String tokenstr = split[0];
                String token = tokenstr.split("=")[1];
                System.out.println(token);
                return token;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;

    }

    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://api.github.com/user?access_token="+accessToken)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
            return null;

    }

}
