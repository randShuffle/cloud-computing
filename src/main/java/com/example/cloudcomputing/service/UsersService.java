package com.example.cloudcomputing.service;


import com.example.cloudcomputing.common.Result;

public interface UsersService {
    Result<?> login(String name, String passwd);
    Result<?> register(String name, String passwd, long phone);
}


