package com.github.iammunir.bookstorerestfulapi.controller;

import com.github.iammunir.bookstorerestfulapi.model.WebResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(value = {ConstraintViolationException.class})
    public WebResponse<String> validationHandler(ConstraintViolationException constraintViolationException) {

        return new WebResponse<>(
                400,
                "BAD REQUEST",
                constraintViolationException.getMessage());
    }
}
