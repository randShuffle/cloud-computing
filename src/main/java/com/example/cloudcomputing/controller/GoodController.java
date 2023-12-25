package com.example.cloudcomputing.controller;

import com.example.cloudcomputing.common.Result;
import com.example.cloudcomputing.mapper.GoodMapper;
import com.example.cloudcomputing.mapper.GoodMapper;
import com.example.cloudcomputing.pojo.Good;
import org.apache.hadoop.hive.metastore.api.Decimal;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodController {
    @Resource
    private GoodMapper goodMapper;
    @PutMapping("")
    public Result<?>addGood(@RequestParam String name, @RequestParam Integer uid, @RequestParam Integer sales, @RequestParam Integer stockpile, @RequestParam Double price, @RequestParam String img, @RequestParam String main, @RequestParam String detail){

        int res = goodMapper.insert(new Good(name,uid,sales,stockpile,price,img,main,detail,name));
        if(res==0)
            return Result.error(400,"添加失败");
        else
            return Result.success("添加成功",res);
    }
    @GetMapping("/sails")
    Result<?> getGoodsSails(@RequestParam String name){
        Good good = goodMapper.findByName(name);
        if(good==null)
            return Result.error(400,"查询失败，数据库中没有该商品");
        else
            return Result.success("查询成功",good.getSales());
    }
    @GetMapping("/main/detail")
    public Result<?> getGoodsByMainAndDetail(@RequestParam String main,@RequestParam String detail){
        List<Good> goods = goodMapper.findAllByMainAndDetail(main,detail);
        if(goods==null||goods.isEmpty())
            return Result.error(400,"查询失败，数据库中没有该商品");
        else
            return Result.success("查询成功",goods);
    }
    @GetMapping("/main")
    public Result<?> getGoodsByMain(@RequestParam String main){
        List<Good> goods = goodMapper.findAllByMain(main);
        if(goods==null||goods.isEmpty())
            return Result.error(400,"查询失败，数据库中没有该商品");
        else
            return Result.success("查询成功",goods);
    }
    @GetMapping("/all")
    public Result<?> getAllGoods(){
        List<Good> goods = goodMapper.findAll();
        if(goods==null||goods.isEmpty())
            return Result.error(400,"查询失败，数据库中没有该商品");
        else
            return Result.success("查询成功",goods);
    }
    @GetMapping("")
    public Result<?> getGoods(@RequestParam Integer uid){
        List<Good> goods = goodMapper.findAllByUid(uid);


        if(goods==null||goods.isEmpty())
            return Result.error(400,"查询失败，数据库中没有该商品");
        else
            return Result.success("查询成功",goods);
    }




}
