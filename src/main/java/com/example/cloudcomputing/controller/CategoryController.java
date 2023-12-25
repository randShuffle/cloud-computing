package com.example.cloudcomputing.controller;

import com.example.cloudcomputing.common.Result;
import com.example.cloudcomputing.mapper.CategoryMapper;
import com.example.cloudcomputing.pojo.Category;
import lombok.var;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Resource
    private CategoryMapper categoryMapper;

    @GetMapping("")
    public Result<?> getCategories() {
        List<Category> categories = categoryMapper.findAll();
        if(categories.isEmpty())
            return Result.error(400,"查询失败，数据库中没有类别");
        else
            return Result.success("查询成功",categories);
    }
    @GetMapping("/sub")
    public Result<?> getSubCategories(@RequestParam String MainCategory) {
        List<Category> categories = categoryMapper.findAllByMain(MainCategory);
        if(categories.isEmpty())
            return Result.error(400,"查询失败，数据库中没有该类别");
        else
            return Result.success("查询成功",categories);
    }
    @GetMapping("/main")
    public Result<?> getMainCategories() {
        List<String> categories = categoryMapper.queryAllMains();
        if(categories.isEmpty())
            return Result.error(400,"查询失败，数据库中没有类别");
        else{
            HashSet<String> categorySet= new HashSet<>(categories);
            return Result.success("查询成功",categorySet.toArray());
        }

    }

}
