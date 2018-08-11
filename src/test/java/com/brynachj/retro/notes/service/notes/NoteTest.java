package com.brynachj.retro.notes.service.notes;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by brynach on 11/08/2018.
 */
public class NoteTest {

    Note note;

    @Before
    public void setUp() {
        note = new Note();
        note.setTitle("title");
        note.setContent("content");
        note.setDate(new Date());
        note.setId("id");
    }

    @Test
    public void missingANonIdFieldReturnsFalseIfAllFieldsPresent() throws Exception {

        assertFalse(note.missingANonIdField());
    }

    @Test
    public void missingANonIdFieldReturnsFalseIfAllFieldsExceptIdPresent() throws Exception {
        note.setId(null);

        assertFalse(note.missingANonIdField());
    }

    @Test
    public void missingANonIdFieldReturnsTrueIfNoFieldsInitialised() throws Exception {
        Note newNote = new Note();

        assertTrue(newNote.missingANonIdField());
    }

    @Test
    public void missingANonIdFieldReturnsTrueIfTitleIsNull() throws Exception {
        note.setTitle(null);

        assertTrue(note.missingANonIdField());
    }

    @Test
    public void missingANonIdFieldReturnsTrueIfContentIsNull() throws Exception {
        note.setContent(null);

        assertTrue(note.missingANonIdField());
    }

    @Test
    public void missingANonIdFieldReturnsTrueIfDateIsNull() throws Exception {
        note.setDate(null);

        assertTrue(note.missingANonIdField());
    }

    @Test
    public void missingANonIdFieldReturnsTrueIfTitleIsEmpty() throws Exception {
        note.setTitle("");

        assertTrue(note.missingANonIdField());
    }

    @Test
    public void missingANonIdFieldReturnsTrueIfContentIsEmpty() throws Exception {
        note.setContent("");

        assertTrue(note.missingANonIdField());
    }

}