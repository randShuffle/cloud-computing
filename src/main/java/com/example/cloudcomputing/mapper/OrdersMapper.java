package com.example.cloudcomputing.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import com.example.cloudcomputing.pojo.Orders;

import java.util.Date;
import java.util.List;
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {

    @Select("SELECT uid, name, quantity, order_date FROM `orders` WHERE uid = #{uid} AND name = #{name} AND order_date = #{date}")
    @Results({
            @Result(column = "uid", property = "uid"),
            @Result(column = "name", property = "name"),
            @Result(column = "quantity", property = "quantity"),
            @Result(column = "order_date", property = "order_date"),
    })
    List<Orders> findAllByUidAndNameAndDate(@Param("uid")Integer uid, @Param("name")String name, @Param("date")Date date);

    @Select("SELECT uid, name, quantity, order_date FROM `orders` WHERE uid = #{uid}")
    @Results({
            @Result(column = "uid", property = "uid"),
            @Result(column = "name", property = "name"),
            @Result(column = "quantity", property = "quantity"),
            @Result(column = "order_date", property = "order_date"),
    })
    List<Orders> findAllByUid(@Param("uid")Integer uid);


    @Select("SELECT uid, name, quantity, order_date FROM `orders` WHERE name = #{name}")
    @Results({
            @Result(column = "uid", property = "uid"),
            @Result(column = "name", property = "name"),
            @Result(column = "quantity", property = "quantity"),
            @Result(column = "order_date", property = "order_date"),
    })
    List<Orders> findAllByName(@Param("name")String name);




}
