package org.example.springboot;

import jakarta.servlet.http.HttpServletRequest;
import org.example.springboot.dto.errors.ErrorDTO;
import org.example.springboot.exeptions.ItemNotFoundExeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;


@RestControllerAdvice
public class GlobalExeptionHandlar {


    @ExceptionHandler(ItemNotFoundExeption.class)
    public ResponseEntity<ErrorDTO> handleItemNotFoundExeption(ItemNotFoundExeption e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorDTO.builder()
                        .errorPath(request.getRequestURI())
                        .errorCode(HttpStatus.NOT_FOUND.value())
                        .errorBody(e.getMessage())
                        .build());
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleValidationExceptions(MethodArgumentNotValidException ex,
                                                               HttpServletRequest request) {
        Map<String, List<String>> errorBody = new HashMap<>();
        for (FieldError fieldError : ex.getFieldErrors()) {
            String field = fieldError.getField();
            String message = fieldError.getDefaultMessage();
            errorBody.compute(field, (s, strings) -> {
                strings = Objects.requireNonNullElse(strings, new ArrayList<>());
                strings.add(message);
                return strings;
            });
        }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ErrorDTO.builder()
                            .errorPath(request.getRequestURI())
                            .errorCode(HttpStatus.BAD_REQUEST.value())
                            .errorBody(errorBody)
                            .build());
        }
    }

