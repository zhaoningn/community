package com.zhaoning.community.mapper;

import com.zhaoning.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author zhaoning
 * @date 2020/4/25 - 20:23
 */
@Component
@Mapper
public interface QuestionMapper {

    @Insert("insert into question (id,title,description,gmt_create,gmt_modified,creater,view_count,like_count,tag) values (#{id},#{title},#{description},#{gmt_create},#{gmt_modified},#{creater},#{view_count},#{like_count},#{tag})")
    void CreateQuestion(Question question);
}
