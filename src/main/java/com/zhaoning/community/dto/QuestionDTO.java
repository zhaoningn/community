package com.zhaoning.community.dto;

import com.zhaoning.community.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhaoning
 * @date 2020/4/26 - 19:46
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private Long gmt_create;
    private Long gmt_modified;
    private Integer creater;
    private Integer view_count;
    private Integer like_count;
    private String tag;
    private User user;
}
