package com.brynachj.retro.notes.service.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brynach on 11/08/2018.
 */
@RestController
@RequestMapping("notes")
public class NoteController {

    public ArrayList<Note> service = new ArrayList<>();

    @Autowired
    private NoteService noteService;

    @RequestMapping("")
    public List<Note> getNotes() {
        return noteService.getNotes();
    }
}
