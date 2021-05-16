package com.mlts.store.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExcepController {
    private final String STATUS_ERR = "error";

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<CommonError> notFound(NotFoundException nfex){
        var errors = new CommonError(
                nfex.getErrors(),
                nfex.getMessage(),
                STATUS_ERR
        );
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<CommonError> badRequest(BadRequestException brex){
        var errors = new CommonError(
                brex.getErrors(),
                brex.getMessage(),
                STATUS_ERR
        );
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
