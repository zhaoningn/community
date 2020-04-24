package com.zhaoning.community.controller;

import com.zhaoning.community.dto.AccessTokenDTO;
import com.zhaoning.community.dto.GithubUser;
import com.zhaoning.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhaoning
 * @date 2020/4/24 - 14:35
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name = "state") String state){

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("c5e159d8e1416d50b5f2");
        accessTokenDTO.setClient_secret("6aa32b7fe56068fa699acff3879fe1485625f242");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");
        accessTokenDTO.setState(state);

        String accessToker = githubProvider.getAccessToker(accessTokenDTO);

        GithubUser user = githubProvider.getUser(accessToker);
        System.out.println(user.getBio());

        return "index";
    }
}
