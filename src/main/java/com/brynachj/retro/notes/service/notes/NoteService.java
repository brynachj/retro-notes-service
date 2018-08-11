package com.brynachj.retro.notes.service.notes;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brynach on 11/08/2018.
 */
@Service
public class NoteService {

    private List<Note> notes = new ArrayList<>();

    public List<Note> getNotes() {
        return notes;
    }
}
