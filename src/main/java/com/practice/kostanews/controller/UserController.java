package com.practice.kostanews.controller;

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
    private List<UserDto> getAllUser(){ return userService.getAllUsers(); }

    @PostMapping
    private UserDto addUsers(@RequestBody UserDto userDto) { return userService.addUser(userDto); }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) { userService.deleteUser(id);}
}
