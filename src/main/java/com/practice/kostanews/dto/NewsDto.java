package com.practice.kostanews.dto;

import com.practice.kostanews.enums.TagsEnum;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewsDto {
    private Long id;

    @NotBlank(message = "Текст должен быть не пустым и не состоять из пробелов")
    @Size(min = 7, max=100, message = "Текст должен быть не меньше 7 и не больше 100")
    private String title;
    private LocalDateTime createdAt;
    private String description;
    @Nonnull
    private TagsEnum tags;
    private Long userId;
}
