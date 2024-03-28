package com.ota.notesapp.handler;

import com.ota.notesapp.exception.InvalidNoteException;
import com.ota.notesapp.exception.NoteNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NoteControllerAdvice {

    @ExceptionHandler(NoteNotFound.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(NoteNotFound ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidNoteException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(InvalidNoteException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // Add more exception handlers as needed

}