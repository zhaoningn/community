package com.zhaoning.community.controller;

import com.zhaoning.community.dto.CommentDTO;
import com.zhaoning.community.dto.ResultDTO;
import com.zhaoning.community.exception.CustomizeErrorCode;
import com.zhaoning.community.exception.CustomizeException;
import com.zhaoning.community.mapper.CommentMapper;
import com.zhaoning.community.model.Comment;
import com.zhaoning.community.model.User;
import com.zhaoning.community.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhaoning
 * @date 2020/4/30 - 13:58
 */
@Controller
public class CommentController {


    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Object post(@RequestBody CommentDTO commentDTO,
                       HttpServletRequest request){
        User  user = (User) request.getSession().getAttribute("user");
        if (user == null){
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }
        Comment comment = new Comment();
        comment.setParent_id(commentDTO.getParent_id());
        comment.setContent(commentDTO.getContent());
        comment.setType(commentDTO.getType());
        comment.setGmt_create(System.currentTimeMillis());
        comment.setGmt_modified(System.currentTimeMillis());
        comment.setCommentator(user.getId());
        comment.setLike_count(0L);
        commentService.insert(comment);
        return null;

    }
}
