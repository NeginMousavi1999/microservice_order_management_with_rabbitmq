package ir.msv.orderservice.controller;

import ir.msv.orderservice.exception.AppException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Negin Mousavi 1/23/2025 - Thursday
 */
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(AppException.class)
    public ResponseEntity<String> exceptionHandler(AppException exception) {
        return ResponseEntity
                .badRequest()
                .body(
                        exception.getMessage()
                );
    }
}