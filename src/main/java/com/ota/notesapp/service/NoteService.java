package com.ota.notesapp.service;
import com.ota.notesapp.exception.NoteNotFound;
import com.ota.notesapp.model.Note;
import com.ota.notesapp.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService implements NoteServiceImpl {


    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Note createNewNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public List<Note> retrieveAllNotes() {

        return noteRepository.findAll();

    }

    @Override
    public Note retrieveNoteById(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFound(id));
    }

    @Override
    public Note updateNote(Long id, Note note) {

        Note item = noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFound(id));
        item.setTitle(note.getTitle());
        item.setBody(note.getBody());
        return noteRepository.save(item);

    }

    @Override
    public void deleteNote(Long id) {

        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFound( id));
        noteRepository.delete(note);



    }


}
