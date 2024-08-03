package com.invoice.users.exceptions;

import com.invoice.users.models.ProfileErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static com.invoice.users.exceptions.ProfileErrorCatalog.PROFILE_NOT_FOUND;


@RestControllerAdvice
public class ProfileControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProfileNotFoundException.class)
    public ProfileErrorResponse handleProfileNotFoundException() {
        System.out.println("no va");
        return ProfileErrorResponse.builder()
                .code(PROFILE_NOT_FOUND.getCode())
                .message(PROFILE_NOT_FOUND.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    /*@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProfileErrorResponse handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();

        return ProfileErrorResponse.builder()
                .code(INVALID_PROFILE.getCode())
                .message(INVALID_PROFILE.getMessage())
                .details(result.getFieldErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList()))
                .timestamp(LocalDateTime.now())
                .build();
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ProfileErrorResponse handleGenericError(Exception exception) {
        return ProfileErrorResponse.builder()
                .code(GENERIC_PROFILE_ERROR.getCode())
                .message(GENERIC_PROFILE_ERROR.getMessage())
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
