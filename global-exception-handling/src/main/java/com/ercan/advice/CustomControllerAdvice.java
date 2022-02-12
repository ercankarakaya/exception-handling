package com.ercan.advice;

import com.ercan.exception.*;
import org.apache.logging.log4j.*;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.*;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class CustomControllerAdvice extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LogManager.getLogger(CustomControllerAdvice.class);

    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<?> handleEmptyInputException(EmptyInputException emptyInputException) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .statusCode(status.value())
                .statusName(status.name())
                .message(emptyInputException.getMessage())
                .build();

        LOGGER.error(emptyInputException);
        return new ResponseEntity<>(errorResponse, status);
    }

    @ExceptionHandler(value = {NoSuchElementException.class,EmptyResultDataAccessException.class})
    public ResponseEntity<?> handleNoSuchElementException(RuntimeException exception) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .statusCode(status.value())
                .statusName(status.name())
                .message(exception.getMessage())
                .build();

        LOGGER.error(exception);
        return new ResponseEntity<>(errorResponse, status);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
                                                                         HttpHeaders headers,
                                                                         HttpStatus status,
                                                                         WebRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .statusCode(status.value())
                .statusName(status.name())
                .message(ex.getMessage())
                .build();

        LOGGER.error(ex);
        return new ResponseEntity<>(errorResponse, status);
    }

/*
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<?> handleEmptyResultDataAccessException(EmptyResultDataAccessException emptyResultDataAccessException){
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .statusCode(status.value())
                .statusName(status.name())
                .message(emptyResultDataAccessException.getMessage())
                .build();

        LOGGER.error(emptyResultDataAccessException);
        return new ResponseEntity<>(errorResponse, status);
    }
 */

}
