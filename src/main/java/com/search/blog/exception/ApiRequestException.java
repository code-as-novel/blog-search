package com.search.blog.exception;

public class ApiRequestException extends RuntimeException{
    final private static long serialVersionUID = 1L;
    private String message;
    private String statusCode;

    public ApiRequestException(final String message, final String statusCode){
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getMessage(){
        return this.message;
    }

    public String getStatusCode(){
        return this.statusCode;
    }
}
