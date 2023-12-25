package com.example.cloudcomputing.pojo;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/***
 * @author szc
 * finish
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "orders")
public class Orders {
    public Integer uid;
    public String name;
    public String order_date;
    public Integer quantity;


}



//    CREATE TABLE orders (
//        uid INT NOT NULL,
//        name STRING NOT NULL COMMENT '商品名称',
//        quantity INT NOT NULL COMMENT '购买数量',
//        order_date STRING NOT NULL COMMENT '下单时间'
//)