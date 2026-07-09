package com.practice.kostanews.controller;

import com.practice.kostanews.dto.UserDto;
import com.practice.kostanews.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    private List<UserDto> getAllUser(){ return userService.getAllUsers();}
}
