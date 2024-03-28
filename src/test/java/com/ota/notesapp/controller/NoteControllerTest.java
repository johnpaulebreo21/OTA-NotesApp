package com.ota.notesapp.controller;


import com.ota.notesapp.exception.InvalidNoteException;
import com.ota.notesapp.model.Note;
import com.ota.notesapp.service.NoteServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NoteControllerTest {

    @Mock
    private NoteServiceImpl noteServiceImpl;

    @Mock
    private BindingResult bindingResult;

    @InjectMocks
    private NoteController noteController;


    @Test
    void createNewNote() {

        //positive test
        Note note = new Note(1L,"test","test");
        when(noteServiceImpl.createNewNote(any(Note.class))).thenReturn(note);
        when(bindingResult.hasErrors()).thenReturn(false);
        Note result = noteController.createNewNote(note,bindingResult);
        assertEquals("test",result.getBody());

        //negative test
        when(bindingResult.hasErrors()).thenReturn(true);
        Exception exception = assertThrows(InvalidNoteException.class,
                () -> {
                    noteController.createNewNote(note,bindingResult);
                });
        assertEquals("Title and Body must not be blank",exception.getMessage());

    }

    @Test
    void updateNote() {

        //positive test
        Note note = new Note(1L,"test","test"); // Create a sample item
        when(noteServiceImpl.updateNote(anyLong(),any(Note.class))).thenReturn(note);
        when(bindingResult.hasErrors()).thenReturn(false);
        Note result = noteController.updateNote(1L,note,bindingResult);
        assertEquals("test",result.getBody());

        //negative test
        when(bindingResult.hasErrors()).thenReturn(true);
        Exception exception = assertThrows(InvalidNoteException.class,
                () -> {
                    noteController.updateNote(1L,note,bindingResult);
                });
        assertEquals("Title and Body must not be blank",exception.getMessage());

    }
}