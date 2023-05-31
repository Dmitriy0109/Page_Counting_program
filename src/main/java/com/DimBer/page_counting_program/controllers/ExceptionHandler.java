package com.DimBer.page_counting_program.controllers;

import com.DimBer.page_counting_program.dto.Response;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Response> exceptionInfo(RuntimeException runtimeException) {
        return new ResponseEntity<>(new Response(runtimeException.getMessage()), HttpStatus.OK);
    }
}
