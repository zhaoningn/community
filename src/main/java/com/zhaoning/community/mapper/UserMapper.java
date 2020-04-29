package com.zhaoning.community.mapper;

import com.zhaoning.community.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * @author zhaoning
 * @date 2020/4/25 - 9:05
 */
@Mapper
@Component
public interface UserMapper {

    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified,avatar_url) values (#{name},#{account_id},#{token},#{gmt_create},#{gmt_modified},#{avatar_url})")
     void insert(User user);

    @Select("select * from user where token = #{token}")
    User fingByToken(@Param("token") String token);

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Integer id);

    @Select("select * from user where account_id = #{account_id}")
    User findByAccountId(@Param("account_id") String account_id);

    @Update("update user set name = #{name},token = #{token}, gmt_modified = #{gmt_modified}, avatar_url=#{avatar_url} where id = #{id}")
    void update(User user);
}
