package com.example.cloudcomputing.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "category")
@Data
public class Category {
    private String main;
    private String detail;
}
