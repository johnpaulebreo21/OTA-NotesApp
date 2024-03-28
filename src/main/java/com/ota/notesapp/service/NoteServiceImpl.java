package com.ota.notesapp.service;

import com.ota.notesapp.model.Note;

import java.util.List;

public interface NoteServiceImpl {
    Note createNewNote(Note note);

    List<Note> retrieveAllNotes();

    Note retrieveNoteById(Long id);

    Note updateNote(Long id,Note note);

    void deleteNote(Long id);
}
