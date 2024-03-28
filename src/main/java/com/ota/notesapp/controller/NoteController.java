package com.ota.notesapp.controller;


import com.ota.notesapp.exception.InvalidNoteException;
import com.ota.notesapp.model.Note;
import com.ota.notesapp.service.NoteServiceImpl;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("notes")
public class NoteController {

    @Autowired
    private NoteServiceImpl noteService;

    @PostMapping
    public Note createNewNote(@Valid @RequestBody Note note, BindingResult result){
        if (result.hasErrors()) {
            throw new InvalidNoteException();
        }

        return noteService.createNewNote(note);

    }

    @GetMapping
    public List<Note> retrieveAllNotes() {
        return noteService.retrieveAllNotes();
    }

    @GetMapping("/{id}")
    public Note retrieveNoteById(@PathVariable Long id){
        return noteService.retrieveNoteById(id);
    }

    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Long id,@Valid @RequestBody Note note, BindingResult result) {
        if (result.hasErrors()) {
            throw new InvalidNoteException();
        }

        return noteService.updateNote(id,note);
    }


    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {

        noteService.deleteNote(id);
    }





}
