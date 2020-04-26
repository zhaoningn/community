package com.zhaoning.community.controller;

import com.zhaoning.community.mapper.QuestionMapper;
import com.zhaoning.community.mapper.UserMapper;
import com.zhaoning.community.model.Question;
import com.zhaoning.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.misc.Request;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author zhaoning
 * @date 2020/4/25 - 19:14
 */
@Controller
public class PublishController {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }



    @PostMapping("/publish")
    public String doPublish(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("tag") String tag,
            HttpServletRequest  request,
            Model model){

        model.addAttribute("title",title);


        if( title == null || title==""){
            model.addAttribute("error","标题不能为空");
            return "publish";
        }
        model.addAttribute("description",description);
        if( description == null || description==""){
            model.addAttribute("error","问题补充不能为空");
            return "publish";
        }
        model.addAttribute("tag",tag);
        if( tag == null || tag==""){
            model.addAttribute("error","标签不能为空");
            return "publish";
        }



        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        User user = null;
        //加user
        Cookie[] cookies = request.getCookies();
        if (cookies != null&& cookies.length!=0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    user = userMapper.fingByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }
        if(user==null){
            model.addAttribute("error","用户未登录");
            return "publish";
        }
        question.setCreater(user.getId());
        question.setGmt_create(System.currentTimeMillis());
        question.setGmt_modified(question.getGmt_create());
        questionMapper.CreateQuestion(question);
        return "redirect:/";
    }
}
