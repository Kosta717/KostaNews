package com.practice.kostanews.dto;

import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDto {
    private String name;
    private String email;
    private String job;

    //@OneToMany

}
