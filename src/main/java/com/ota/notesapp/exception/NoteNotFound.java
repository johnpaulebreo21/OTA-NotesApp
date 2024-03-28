package com.ota.notesapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoteNotFound extends RuntimeException {
    private static final String message = "Note not found with id ";
    public NoteNotFound(Long id) {
        super(message + id.toString());
    }
}
