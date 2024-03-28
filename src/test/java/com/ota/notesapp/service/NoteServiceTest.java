package com.ota.notesapp.service;

import com.ota.notesapp.exception.NoteNotFound;
import com.ota.notesapp.model.Note;
import com.ota.notesapp.repository.NoteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class NoteServiceTest {

    @Mock
    private NoteRepository noteRepository;

    @InjectMocks
    private NoteService noteService;

    @Test
    void retrieveNoteById() {

        //positive test
        Note note = new Note(1L, "test", "test");
        when(noteRepository.findById(anyLong())).thenReturn(Optional.of(note));
        Note result = noteService.retrieveNoteById(1l);
        assertEquals("test", note.getBody());

        //negative test
        when(noteRepository.findById(anyLong())).thenReturn(Optional.empty());
        Exception exception = assertThrows(NoteNotFound.class,
                () -> {
                    noteService.retrieveNoteById(1L);
                });
        assertEquals("Note not found with id 1", exception.getMessage());

    }

    @Test
    void updateNote() {
        //positive test
        Note note = new Note(1L, "test", "test");
        when(noteRepository.findById(anyLong())).thenReturn(Optional.of(note));
        Note result = noteService.updateNote(1l, note);
        assertEquals("test", note.getBody());

        //negative test
        when(noteRepository.findById(anyLong())).thenReturn(Optional.empty());
        Exception exception = assertThrows(NoteNotFound.class,
                () -> {
                    noteService.updateNote(1L, note);
                });
        assertEquals("Note not found with id 1", exception.getMessage());
    }

    @Test
    void deleteNote() {
        //positive test
        Note note = new Note(1L, "test", "test");
        when(noteRepository.findById(anyLong())).thenReturn(Optional.of(note));
        assertDoesNotThrow(

                () -> {
                    noteService.deleteNote(1l);
                });

        //negative test
        when(noteRepository.findById(anyLong())).thenReturn(Optional.empty());
        Exception exception = assertThrows(NoteNotFound.class,
                () -> {
                    noteService.deleteNote(1L);
                });
        assertEquals("Note not found with id 1", exception.getMessage());
    }
}