package com.aeon.library;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LibraryExceptionHandler {

    @ExceptionHandler(LibraryException.class)
    public ResponseEntity<?> handleLibraryException(
            LibraryException libraryException
    ) {
        return new ResponseEntity<>(libraryException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
