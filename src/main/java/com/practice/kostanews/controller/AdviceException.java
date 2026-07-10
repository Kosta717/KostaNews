package com.practice.kostanews.controller;

import com.practice.kostanews.dto.ExceptionResponseDTO;
import com.practice.kostanews.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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

}
