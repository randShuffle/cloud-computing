package com.example.cloudcomputing.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.cloudcomputing.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
    // 查询所有分类
    @Select("SELECT main, detail FROM `category`")
    @Results({
            @Result(column = "main", property = "main"),
            @Result(column = "detail", property = "detail")
    })
    List<Category> findAll();

    // 根据主分类查询
    @Select("SELECT main, detail FROM category WHERE main = #{main}")
    List<Category> findAllByMain(String main);

    // 根据细节分类查询
    @Select("SELECT main, detail FROM category WHERE detail = #{detail}")
    List<Category> findAllByDetail(String detail);

    // 查询所有主分类
    @Select("SELECT main FROM category")
    @Results({
            @Result(column = "main", property = "main")})
        List<String> queryAllMains();
}
