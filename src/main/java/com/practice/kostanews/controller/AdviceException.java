package com.practice.kostanews.controller;

import com.practice.kostanews.dto.ExceptionResponseDTO;
import com.practice.kostanews.exception.CustomException;
import com.practice.kostanews.exception.NotFoundException;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

@RestControllerAdvice
public class AdviceException
{
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionResponseDTO> customException(CustomException e)
    {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ExceptionResponseDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(),e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponseDTO> customException(MethodArgumentNotValidException e)
    {
        var a = Arrays.stream(e.getBindingResult().getSuppressedFields()).findFirst().orElse("Текст должен быть не пустым и не состоять из пробелов. " +
                "Текст должен быть не меньше 7 и не больше 100");
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponseDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), a));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> notFoundException(NotFoundException e)
    {
        ExceptionResponseDTO responseDTO = new ExceptionResponseDTO(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
    }


}
