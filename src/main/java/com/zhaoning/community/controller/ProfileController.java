package com.zhaoning.community.controller;

import com.sun.corba.se.spi.ior.IdentifiableFactory;
import com.zhaoning.community.dto.PaginationDTO;
import com.zhaoning.community.mapper.QuestionMapper;
import com.zhaoning.community.mapper.UserMapper;
import com.zhaoning.community.model.User;
import com.zhaoning.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author zhaoning
 * @date 2020/4/28 - 9:28
 */
@Controller
public class ProfileController {

    @Autowired
    QuestionService questionServicer;

    @Autowired
    UserMapper userMapper;

    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name = "action") String action,
                          Model model,
                          @RequestParam(name = "page",defaultValue = "1") Integer page,
                          @RequestParam(name = "size",defaultValue = "5") Integer size,
                          HttpServletRequest request){

        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            return "redirect:/";
        }


        if ("questions".equals(action)){
            model.addAttribute("section","questions");
            model.addAttribute("sectionName","我的提问");
        }else if ("replies".equals(action)){
            model.addAttribute("section","replies");
            model.addAttribute("sectionName","最新回复");

        }

        PaginationDTO paginationDTO = questionServicer.questionList(user.getId(), page, size);

        model.addAttribute("pagination",paginationDTO);

        return "profile";
    }
}
