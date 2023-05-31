package com.DimBer.page_counting_program.handlers;

import com.DimBer.page_counting_program.dto.ApiErrorDTO;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiErrorDTO> exceptionInfo(RuntimeException runtimeException) {
        return new ResponseEntity<>(new ApiErrorDTO(runtimeException.getMessage()), HttpStatus.OK);
    }
}
