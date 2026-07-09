package com.practice.kostanews.service;

import com.practice.kostanews.dto.NewsDto;
import com.practice.kostanews.dto.UserDto;
import com.practice.kostanews.entity.NewsEntity;
import com.practice.kostanews.entity.UserEntity;
import com.practice.kostanews.exception.CustomException;
import com.practice.kostanews.repository.NewsRepository;
import com.practice.kostanews.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    NewsRepository newsRepository;
    @Autowired
    UserRepository userRepository;

    public List<UserDto> getAllUsers()
    {
        return userRepository.findAll().stream()
                .map(user_entity -> UserDto.builder()
                        .id(user_entity.getId())
                        .name(user_entity.getName())
                        .email(user_entity.getEmail())
                        .jobs(user_entity.getJobs())
                        .build()
                ).toList();
    }

    public UserDto addUser(UserDto userDto){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDto.getName());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setJobs(userDto.getJobs());

        UserEntity result = userRepository.save(userEntity);

        return UserDto.builder()
                .name(result.getName())
                .email(result.getEmail())
                .jobs(result.getJobs())
                .build();
    }

    @Transactional(readOnly = true)
    public List<NewsDto> getAllNewsUser(Long userId) {

        List<NewsEntity> userNews = newsRepository.findAllByAuthor_Id(userId);
        return userNews.stream()
                .map(entity -> NewsDto.builder()
                        .id(entity.getId())
                        .title(entity.getTitle())
                        .description(entity.getDescription())
                        .tags(entity.getTags())
                        .userId(userId)
                        .build()
                ).toList();
    }

    @Transactional
    public void deleteUser(Long id) {
        UserEntity entity = userRepository.findById(id)
                .orElseThrow(() -> new CustomException("Нет такой задачи!"));
        userRepository.deleteById(entity.getId());
    }
}
