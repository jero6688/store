package com.example.mapper;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("insert into t_user values(null,#{username},#{password},#{role})")
    void add(User user);

    @Select("select password from t_user where username=#{username}")
    User selectByUsername(String username);

    @Select("select * from t_user")
    List<User> findAll();


}
