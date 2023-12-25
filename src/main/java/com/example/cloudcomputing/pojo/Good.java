package com.example.cloudcomputing.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "good")
@Data
public class Good {

    private String name;
    private Integer uid;
    private Integer sales;
    private Integer stockpile;
    private BigDecimal price;
    private String main;
    private String detail;
    private String img;
    private String comment;

    // toString方法
    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                ", uid=" + uid +
                ", sales=" + sales +
                ", stockpile=" + stockpile +
                ", price=" + price +
                ", main='" + main + '\'' +
                ", detail='" + detail + '\'' +
                ", img='" + img + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}