package com.zhaoning.community.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhaoning
 * @date 2020/4/30 - 13:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private Long parent_id;
    private String content;
    private Integer type;
}
