package com.zhaoning.community.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhaoning
 * @date 2020/4/24 - 15:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;
}
