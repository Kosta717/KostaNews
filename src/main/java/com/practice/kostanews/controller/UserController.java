package com.practice.kostanews.controller;

import com.practice.kostanews.dto.NewsDto;
import com.practice.kostanews.dto.UserDto;
import com.practice.kostanews.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<UserDto> getAllUser(){ return userService.getAllUsers(); }

    @GetMapping("/{id}/news")
    public List<NewsDto> getAllUserNews(@PathVariable Long id) { return userService.getAllNewsUser(id);}

    @PostMapping
    public UserDto addUsers(@RequestBody UserDto userDto) { return userService.addUser(userDto); }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) { userService.deleteUser(id);}
}
