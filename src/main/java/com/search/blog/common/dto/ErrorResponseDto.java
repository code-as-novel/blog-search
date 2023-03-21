package com.search.blog.common.dto;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponseDto {
    private String status;
    private String errorMessage;

    public static ErrorResponseDto of(BindException ex){
        return new ErrorResponseDto(HttpStatus.BAD_REQUEST.name(), getMessage(ex.getBindingResult()));
    }

    public static ErrorResponseDto of(MethodArgumentNotValidException ex){
        return new ErrorResponseDto(HttpStatus.BAD_REQUEST.name(), getMessage(ex.getBindingResult()));
    }

    public static ErrorResponseDto of(Exception ex){
        return new ErrorResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.name(), ex.getMessage());
    }

    private static String getMessage(BindingResult result){
        StringBuilder message = new StringBuilder();
        for (FieldError fieldError : result.getFieldErrors()) {
            message.append(fieldError.getField());
            message.append(" : ");
            message.append(fieldError.getDefaultMessage());
        }

        return message.toString();
    }
}
