package com.example.cloudcomputing.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.cloudcomputing.pojo.Good;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface GoodMapper extends BaseMapper<Good> {
    // 查询所有Good记录
    @Select("SELECT name,uid,sales,stockpile,price,main,detail,img,comment FROM `good`")
    @Results({
            @Result(column = "name", property = "name"),
            @Result(column = "uid", property = "uid"),
            @Result(column = "sales", property = "sales"),
            @Result(column = "stockpile", property = "stockpile"),
            @Result(column = "price", property = "price"),
            @Result(column = "main", property = "main"),
            @Result(column = "detail", property = "detail"),
            @Result(column = "img", property = "img"),
            @Result(column = "comment", property = "comment"),
    })
    List<Good> findAll();

    // 根据name查询Good记录
    @Select("SELECT name,uid,sales,stockpile,price,main,detail,img,comment FROM good WHERE name = #{name}")
    @Results({
            @Result(column = "name", property = "name"),
            @Result(column = "uid", property = "uid"),
            @Result(column = "sales", property = "sales"),
            @Result(column = "stockpile", property = "stockpile"),
            @Result(column = "price", property = "price"),
            @Result(column = "main", property = "main"),
            @Result(column = "detail", property = "detail"),
            @Result(column = "img", property = "img"),
            @Result(column = "comment", property = "comment"),
    })
    Good findByName(@Param("name") String name);

    // 根据uid查询Good记录
    @Select("SELECT name,uid,sales,stockpile,price,main,detail,img,comment FROM `good` WHERE uid = #{uid}")
    @Results({
            @Result(column = "name", property = "name"),
            @Result(column = "uid", property = "uid"),
            @Result(column = "sales", property = "sales"),
            @Result(column = "stockpile", property = "stockpile"),
            @Result(column = "price", property = "price"),
            @Result(column = "main", property = "main"),
            @Result(column = "detail", property = "detail"),
            @Result(column = "img", property = "img"),
            @Result(column = "comment", property = "comment"),
    })
    List<Good> findAllByUid(@Param("uid") Integer uid);


    // 根据main查询Good记录
    @Select("SELECT name,uid,sales,stockpile,price,main,detail,img,comment FROM good WHERE main = #{main}")
    @Results({
            @Result(column = "name", property = "name"),
            @Result(column = "uid", property = "uid"),
            @Result(column = "sales", property = "sales"),
            @Result(column = "stockpile", property = "stockpile"),
            @Result(column = "price", property = "price"),
            @Result(column = "main", property = "main"),
            @Result(column = "detail", property = "detail"),
            @Result(column = "img", property = "img"),
            @Result(column = "comment", property = "comment"),
    })
    List<Good> findAllByMain(@Param("main") String main);

    // 根据main和detail查询Good记录
    @Select("SELECT name,uid,sales,stockpile,price,main,detail,img,comment FROM good WHERE main = #{main} AND detail = #{detail}")
    @Results({
            @Result(column = "name", property = "name"),
            @Result(column = "uid", property = "uid"),
            @Result(column = "sales", property = "sales"),
            @Result(column = "stockpile", property = "stockpile"),
            @Result(column = "price", property = "price"),
            @Result(column = "main", property = "main"),
            @Result(column = "detail", property = "detail"),
            @Result(column = "img", property = "img"),
            @Result(column = "comment", property = "comment"),
    })
    List<Good> findAllByMainAndDetail(@Param("main") String main, @Param("detail") String detail);
}
