package com.rest.client.producer.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFound.class)
    ProblemDetail problemDetail(EmployeeNotFound employeeNotFound) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problemDetail.setDetail(employeeNotFound.getMessage());
        return problemDetail;
    }

    @ExceptionHandler(Exception.class)
    ProblemDetail problemDetail(Exception exception) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        problemDetail.setDetail(exception.getMessage());
        return problemDetail;
    }
}
