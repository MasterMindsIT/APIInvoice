package com.invoice.invoices.exceptions;

import com.invoice.invoices.models.InvoiceErrorResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static com.invoice.invoices.exceptions.InvoiceErrorCatalog.*;
@RestControllerAdvice
public class InvoiceControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(InvoiceNotFoundException.class)
    public InvoiceErrorResponse handleInvoiceNotFoundException(){
     return InvoiceErrorResponse.builder()
             .code(INVOICE_NOT_FOUND.getCode())
             .message(INVOICE_NOT_FOUND.getCode())
             .timestamp(LocalDateTime.now())
             .build();
    }

/*    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public InvoiceErrorResponse handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();

        return InvoiceErrorResponse.builder()
                .code(INVALID_INVOICE.getCode())
                .message(INVALID_INVOICE.getMessage())
                .details(result.getFieldErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList()))
                .timestamp(LocalDateTime.now())
                .build();
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public InvoiceErrorResponse handleGenericError(Exception exception) {
        return InvoiceErrorResponse.builder()
                .code(GENERIC_INVOICE_ERROR.getCode())
                .message(GENERIC_INVOICE_ERROR.getMessage())
                .details(Collections.singletonList(exception.getMessage()))
                .timestamp(LocalDateTime.now())
                .build();
    }*/
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleFieldErrors(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();

        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return errors;
    }
}
