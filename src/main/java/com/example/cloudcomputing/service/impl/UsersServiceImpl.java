package com.example.cloudcomputing.service.impl;


import com.example.cloudcomputing.common.Result;
import com.example.cloudcomputing.mapper.UsersMapper;
import com.example.cloudcomputing.pojo.Users;
import com.example.cloudcomputing.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersMapper userDao;

    @Override
    public Result<?> login(String name, String passwd) {
        Users user = userDao.findByName(name);
        if (user == null) {
            return Result.error(404, "User not found");
        }
        if (!user.getPasswd().equals(passwd)) {
            return Result.error(400, "Wrong password");
        }
        return Result.success("Login success", user);
    }

    @Override
    public Result<?> register(String name, String passwd, long phone) {
        Users user = userDao.findByName(name);
        if (user != null) {
            return Result.error(400, "User already exists");
        }
        user = new Users();
        user.setName(name);
        user.setPasswd(passwd);
        user.setPhone(phone);
        System.out.println(user);
        //szc modified:still need testing
        userDao.insert(user);

        return Result.success("Register success", user);
    }


}
