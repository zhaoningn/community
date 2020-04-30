package com.zhaoning.community.exception;

/**
 * @author zhaoning
 * @date 2020/4/30 - 8:55
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUNT(2001,"你的问题不见了"),
    TARGET_PARAM_NOT_FOUNT(2002,"未选中任何问题或评论进行回复"),
    NO_LOGIN(2003,"未登录，不能进行评论");

    private Integer code;
    private String message;

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }

    CustomizeErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
