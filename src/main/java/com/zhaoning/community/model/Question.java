package com.zhaoning.community.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.lang.model.element.NestingKind;

/**
 * @author zhaoning
 * @date 2020/4/25 - 20:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    private Integer id;
    private String title;
    private String description;
    private Long gmt_create;
    private Long gmt_modified;
    private Integer creater;
    private Integer view_count;
    private Integer like_count;
    private String tag;

}
