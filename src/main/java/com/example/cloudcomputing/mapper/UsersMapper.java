package com.example.cloudcomputing.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.cloudcomputing.pojo.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

/***
 * @author szc
 * finish
 */



@Mapper
public interface UsersMapper extends BaseMapper<Users> {
    @Select("SELECT id, name, passwd, phone, role FROM `users` WHERE name = #{name}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "passwd", property = "passwd"),
            @Result(column = "phone", property = "phone"),
            @Result(column = "role", property = "role")
    })
    public Users findByName(@Param("name") String name);

}


