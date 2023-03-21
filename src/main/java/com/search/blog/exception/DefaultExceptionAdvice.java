package com.search.blog.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.search.blog.constant.ResponseEntityConstant;
import com.search.blog.constant.StatusCodeConstant;

@ControllerAdvice
public class DefaultExceptionAdvice {
    
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleException(final Exception exception){
        exception.printStackTrace();

        Map<String, Object> result = new HashMap<>();
        result.put(ResponseEntityConstant.STATUS_CODE, StatusCodeConstant.INTERNAL_SERVER_ERROR);
        result.put(ResponseEntityConstant.ERROR_MESSAGE, exception.getMessage());

        return ResponseEntity.ok(result);
    }
}
