package com.zhaoning.community.mapper;

import com.zhaoning.community.model.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author zhaoning
 * @date 2020/4/30 - 14:01
 */
@Mapper
@Component
public interface CommentMapper {

    @Insert("insert into comment (id,parent_id,type,commentator,gmt_create,gmt_modified,like_count,content) values(#{id},#{parent_id},#{type},#{commentator},#{gmt_create},#{gmt_modified},#{like_count},#{content}) ")
    void insert(Comment comment);
}
