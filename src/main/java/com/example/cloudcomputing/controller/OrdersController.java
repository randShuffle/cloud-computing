package com.example.cloudcomputing.controller;


import com.example.cloudcomputing.common.Result;
import com.example.cloudcomputing.service.OrdersService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Resource
    private OrdersService orderService;

    @GetMapping("")
    public Result<?> getOrders(@RequestParam Integer uid){
        return orderService.getOrders(uid);
    }
    @GetMapping("/name")
    public Result<?> getOrdersByName(@RequestParam String name){
        return orderService.getOrdersByName(name);
    }
    @GetMapping("/uid/name/date")
    public Result<?> getOrdersByUidAndNameAndDate(@RequestParam Integer uid,@RequestParam String name,@RequestParam String date){
        return orderService.getOrdersByUidAndNameAndDate(uid,name,date);
    }
    @PutMapping("")
    public Result<?> addOrders(@RequestParam Integer uid,@RequestParam String name,@RequestParam String date,@RequestParam Integer quantity){
        return orderService.addOrders(uid,name,null,quantity);
    }
}
