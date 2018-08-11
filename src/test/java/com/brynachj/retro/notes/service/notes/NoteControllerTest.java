package com.brynachj.retro.notes.service.notes;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by brynach on 11/08/2018.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class NoteControllerTest {

    @Autowired
    NoteController controller;

    @MockBean
    NoteService noteService;

    List<Note> noteList;

    @Before
    public void setUp() {
        noteList = new ArrayList<>();
    }

    @Test
    public void getNotesReturnsAnEmptyListOfNotesWhenNothingIsReturnedFromService() {

        assertEquals(Collections.emptyList(), controller.getNotes());
    }

    @Test
    public void getNotesReturnsAListOfSizeOneWhenASingleNoteIsReturnedFromService() {
        noteList.add(new Note());
        when(noteService.getNotes()).thenReturn(noteList);

        assertEquals(1, controller.getNotes().size());
    }



    @Test
    public void getNotesReturnsAListOfSizeTwoWhenTwoNotesAreReturnedFromService() {
        noteList.add(new Note());
        noteList.add(new Note());
        when(noteService.getNotes()).thenReturn(noteList);

        assertEquals(2, controller.getNotes().size());
    }

    @Test
    public void getNotesReturnsANoteWhenASingleNoteIsReturnedFomService() {
        noteList.add(new Note());
        when(noteService.getNotes()).thenReturn(noteList);

        assertEquals(Note.class, controller.getNotes().get(0).getClass());
    }

    @Test
    public void getNotesReturnsTheSameNoteThatIsReturnedFromService() {
        Note note = new Note();
        noteList.add(note);
        when(noteService.getNotes()).thenReturn(noteList);

        assertEquals(note, controller.getNotes().get(0));
    }

    @Test
    public void getNotesReturnsTheSameListOfNotesThatIsReturnedFromService() {
        Note note = new Note();
        Note note2 = new Note();
        noteList.add(note);
        noteList.add(note2);
        when(noteService.getNotes()).thenReturn(noteList);

        assertEquals(noteList, controller.getNotes());
    }
}