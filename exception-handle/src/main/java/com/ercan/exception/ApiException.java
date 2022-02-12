package com.ercan.exception;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
@Builder
@RequiredArgsConstructor
public class ApiException {
    private final String message;
    //private final Throwable throwable;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp;
}
