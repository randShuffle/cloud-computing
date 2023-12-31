package com.example.cloudcomputing.service;



import com.example.cloudcomputing.common.Result;

import java.util.Date;

public interface OrdersService {
    Result<?> getOrders(Integer uid);
    Result<?> getOrdersByName(String name);
    Result<?> getOrdersByUidAndNameAndDate(Integer uid, String name, String date);
    Result<?> addOrders(Integer uid, String name, String date, Integer quantity);
}
