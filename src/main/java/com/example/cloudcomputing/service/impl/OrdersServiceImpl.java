package com.example.cloudcomputing.service.impl;


import com.example.cloudcomputing.common.Result;
import com.example.cloudcomputing.mapper.GoodMapper;
import com.example.cloudcomputing.mapper.OrdersMapper;
import com.example.cloudcomputing.pojo.Good;
import com.example.cloudcomputing.pojo.Orders;
import com.example.cloudcomputing.service.OrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Resource
    private OrdersMapper ordersDao;
    @Resource
    private GoodMapper goodDao;

    @Override
    public Result<?> getOrders(Integer uid) {
        List<Orders> ordersList = ordersDao.findAllByUid(uid);
        return Result.success("Get orders successfully", ordersList);
    }

    @Override
    public Result<?> getOrdersByName(String name) {
        List<Orders> ordersList = ordersDao.findAllByName(name);
        return Result.success("Get orders successfully", ordersList);
    }

    @Override
    public Result<?> getOrdersByUidAndNameAndDate(Integer uid, String name, Date date) {
        List<Orders> ordersList = ordersDao.findAllByUidAndNameAndDate(uid, name, date);
        return Result.success("Get orders successfully", ordersList);
    }

    @Override
    public Result<?> addOrders(Integer uid, String name, Date date, Integer quantity) {
        if(date==null){
            // 获取当前时间
            date = new Date();
        }
        Good good=goodDao.findByName(name);
        if(good==null){
            return Result.error(400,"This good does not exist");
        }
        if(quantity>good.getStockpile()){
            return Result.error(400,"The stockpile is not enough");
        }
        List<?> orderss=ordersDao.findAllByUidAndNameAndDate(uid,name,date);
        if(orderss==null|| orderss.isEmpty()){
            Orders orders = new Orders(uid, name, date, quantity);
            ordersDao.insert(orders);
            good.setSales(good.getSales()+quantity);
            good.setStockpile(good.getStockpile()-quantity);
            goodDao.insert(good);
            System.out.println(orders);
            return Result.success("Add orders successfully", orders);
        }else{
            return Result.error(400,"This order already exists");
        }
    }


}
