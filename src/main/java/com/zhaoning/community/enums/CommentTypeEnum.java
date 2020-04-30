package com.zhaoning.community.enums;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * @author zhaoning
 * @date 2020/4/30 - 15:10
 */
public enum CommentTypeEnum {

    QUESTION(1),
    COMMENT(2);
    private Integer type;

    public Integer getType() {
        return type;
    }

    CommentTypeEnum(Integer type){
        this.type = type;
    }
}
