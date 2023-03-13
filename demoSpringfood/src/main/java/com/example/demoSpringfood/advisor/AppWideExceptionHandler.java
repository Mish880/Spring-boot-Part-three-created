package com.example.demoSpringfood.advisor;

import com.example.demoSpringfood.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class AppWideExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({Exception.class})

    public ResponseUtil exceptionHandler(Exception e) {
        return new ResponseUtil(500,e.getMessage(),null);
    }
}
