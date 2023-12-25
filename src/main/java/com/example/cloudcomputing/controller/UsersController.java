package com.example.cloudcomputing.controller;

import com.example.cloudcomputing.dto.UserDTO;
import com.example.cloudcomputing.service.UsersService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UsersController {

    @Resource
    private UsersService userService;

    @PostMapping("/login")
    public Object login(@RequestBody UserDTO userDTO) {

        return userService.login(userDTO.getName(), userDTO.getPasswd());
    }

    @PutMapping("/register")
    public Object register(@RequestBody UserDTO userDTO) {
        return userService.register(userDTO.getName(), userDTO.getPasswd(), userDTO.getPhone());
    }




}
