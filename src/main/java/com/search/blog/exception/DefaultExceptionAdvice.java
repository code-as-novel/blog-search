package com.search.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.search.blog.common.dto.ErrorResponseDto;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class DefaultExceptionAdvice {
    
    @ExceptionHandler(FeignException.class)
    protected ResponseEntity<Object> handleException(final FeignException feignException){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        try{
           status = HttpStatus.valueOf(feignException.status());
        }catch(Exception e){}

        return new ResponseEntity<>(new ErrorResponseDto(status.name(), feignException.getMessage()), status);
    }

    @ExceptionHandler(BindException.class)
    protected ResponseEntity<Object> handleException(final BindException bindException){
        return new ResponseEntity<>(ErrorResponseDto.of(bindException), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleException(final MethodArgumentNotValidException methodArgumentNotValidException){
        return new ResponseEntity<>(ErrorResponseDto.of(methodArgumentNotValidException), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleException(final Exception exception){
        log.error(exception.getMessage());

        return new ResponseEntity<>(ErrorResponseDto.of(exception), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
