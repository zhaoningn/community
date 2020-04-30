package com.zhaoning.community.controller;

import com.zhaoning.community.dto.PaginationDTO;
import com.zhaoning.community.dto.QuestionDTO;
import com.zhaoning.community.mapper.QuestionMapper;
import com.zhaoning.community.mapper.UserMapper;
import com.zhaoning.community.model.Question;
import com.zhaoning.community.model.User;
import com.zhaoning.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author zhaoning
 * @date 2020/4/24 - 13:19
 */
@Controller
public class IndexController {



    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(name = "page",defaultValue = "1") Integer page,
                        @RequestParam(name = "size",defaultValue = "5") Integer size){


        PaginationDTO pagination= questionService.list(page,size);
        model.addAttribute("pagination",pagination);

        return "index";
    }
}
