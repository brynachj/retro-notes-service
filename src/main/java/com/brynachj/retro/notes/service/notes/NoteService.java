package com.brynachj.retro.notes.service.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by brynach on 11/08/2018.
 */
@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<Note> getNotes() {
        return noteRepository.findAll();
    }

    public void addNote(Note note) {
        if(note == null || note.missingANonIdField()) {
            throw new IllegalArgumentException("Tried to add a null note or one with a missing field to the db");
        }
        note.setId(UUID.randomUUID().toString());
        noteRepository.insert(note);
    }
}
