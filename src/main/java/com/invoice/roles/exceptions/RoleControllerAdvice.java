package com.invoice.roles.exceptions;

import com.invoice.brands.exceptions.BrandNotFounfException;
import com.invoice.brands.models.BrandsErrorResponse;
import com.invoice.roles.models.RoleErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static com.invoice.roles.exceptions.RoleErrorCatalog.ROLES_NOT_FOUND;

@RestControllerAdvice
public class RoleControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RoleNotFoundException.class)
    public RoleErrorResponse handlerOLESNotFoundException() {
        return RoleErrorResponse.builder()
                .code(ROLES_NOT_FOUND.getCode())
                .message(ROLES_NOT_FOUND.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleFieldErrors(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();

        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return errors;
    }
}
