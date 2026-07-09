package com.practice.kostanews.service;

import com.practice.kostanews.dto.UserDto;
import com.practice.kostanews.entity.UserEntity;
import com.practice.kostanews.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserDto> getAllUsers()
    {
        return userRepository.findAll().stream()
                .map(user_entity -> UserDto.builder()
                        .name(user_entity.getName())
                        .email(user_entity.getEmail())
                        .jobs(user_entity.getJobs())
                        .build()
                ).toList();
    }


}
