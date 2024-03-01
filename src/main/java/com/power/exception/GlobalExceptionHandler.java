package com.power.exception;

import com.power.payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    public ResponseEntity<ErrorDetails> resourceNotFound(ResourceNotFound ex, WebRequest webRequest){
        ErrorDetails err = new ErrorDetails(new Date(), ex.getMessage(), webRequest.getDescription(true));
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }
}
