package com.library.bookmanagementsystem.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
    private boolean success = false;
    private int status;
    private String message;
    private LocalDateTime timestamp;
}