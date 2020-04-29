package com.zhaoning.community.controller;

import com.zhaoning.community.dto.QuestionDTO;
import com.zhaoning.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhaoning
 * @date 2020/4/28 - 16:28
 */
@Controller
public class QuestionController {


    @Autowired
    QuestionService questionService;



    @GetMapping("/question/{id}")
    public String detquestion(@PathVariable("id") Integer id,
                              Model model){

        QuestionDTO questionDTO = questionService.getQuestionByid(id);
        model.addAttribute("question",questionDTO);

        return "question";

    }

}
