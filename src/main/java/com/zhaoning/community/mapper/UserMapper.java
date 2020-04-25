package com.zhaoning.community.mapper;

import com.zhaoning.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author zhaoning
 * @date 2020/4/25 - 9:05
 */
@Mapper
@Component
public interface UserMapper {

    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
     void insert(User user);

}
