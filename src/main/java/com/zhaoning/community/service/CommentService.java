package com.zhaoning.community.service;

import com.zhaoning.community.exception.CustomizeErrorCode;
import com.zhaoning.community.exception.CustomizeException;
import com.zhaoning.community.model.Comment;
import org.springframework.stereotype.Service;

/**
 * @author zhaoning
 * @date 2020/4/30 - 15:16
 */
@Service
public class CommentService {
    public void insert(Comment comment) {
        if (comment.getParent_id()==null||comment.getParent_id()==0){
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUNT);
        }

    }
}
