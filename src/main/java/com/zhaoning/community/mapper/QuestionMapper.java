package com.zhaoning.community.mapper;

import com.zhaoning.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhaoning
 * @date 2020/4/25 - 20:23
 */
@Component
@Mapper
public interface QuestionMapper {

    @Insert("insert into question (id,title,description,gmt_create,gmt_modified,creater,view_count,like_count,tag,comment_count) values (#{id},#{title},#{description},#{gmt_create},#{gmt_modified},#{creater},#{view_count},#{like_count},#{tag},#{comment_count})")
    void CreateQuestion(Question question);

    @Select("select * from question limit #{pages},#{size}")
    List<Question> list(@Param(value = "pages") Integer pages,
                        @Param(value = "size") Integer size);

    @Select("select count(1) from question")
    Integer count();
}
