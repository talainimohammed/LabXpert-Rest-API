package org.techlab.labxpert.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> handleException(Exception exception){
        CustomErrorResponse exc = new CustomErrorResponse();
        exc.setStatus(HttpStatus.BAD_REQUEST.value());
        exc.setMessage(exception.getMessage());
        exc.setTimeStamp(System.currentTimeMillis());
        System.out.println(exception);
        return new ResponseEntity<>(exc,HttpStatus.BAD_REQUEST);
    }
}
