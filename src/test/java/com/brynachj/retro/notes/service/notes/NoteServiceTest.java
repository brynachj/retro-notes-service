package com.brynachj.retro.notes.service.notes;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by brynach on 11/08/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class NoteServiceTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @InjectMocks
    NoteService service;

    @Mock
    NoteRepository noteRepository;

    Note note;
    List<Note> noteList;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        note = new Note();
        note.setId("id");
        note.setTitle("title");
        note.setContent("content");
        note.setDate(new Date());

        noteList = new ArrayList<>();
    }

    @Test
    public void getNotesReturnsAnEmptyListOfNotesWhenNothingIsReturnedFromService() {

        assertEquals(Collections.emptyList(), service.getNotes());
    }

    @Test
    public void getNotesReturnsAListOfSizeOneWhenASingleNoteIsReturnedFromService() {
        noteList.add(note);
        when(noteRepository.findAll()).thenReturn(noteList);

        assertEquals(1, service.getNotes().size());
    }

    @Test
    public void getNotesReturnsAListOfSizeTwoWhenTwoNotesAreReturnedFromService() {
        noteList.add(note);
        noteList.add(new Note());
        when(noteRepository.findAll()).thenReturn(noteList);

        assertEquals(2, service.getNotes().size());
    }

    @Test
    public void getNotesReturnsANoteWhenASingleNoteIsReturnedFomService() {
        noteList.add(note);
        when(noteRepository.findAll()).thenReturn(noteList);

        assertEquals(Note.class, service.getNotes().get(0).getClass());
    }

    @Test
    public void getNotesReturnsTheSameNoteThatIsReturnedFromService() {
        noteList.add(note);
        when(noteRepository.findAll()).thenReturn(noteList);

        assertEquals(note, service.getNotes().get(0));
    }

    @Test
    public void getNotesReturnsTheSameListOfNotesThatIsReturnedFromService() {
        Note note2 = new Note();
        noteList.add(note);
        noteList.add(note2);
        when(noteRepository.findAll()).thenReturn(noteList);

        assertEquals(noteList, service.getNotes());
    }

    @Test
    public void addNoteCallsNoteRepositoryInsertWithTheSuppliedNote() {
        service.addNote(note);

        verify(noteRepository, times(1)).insert(note);
    }

    @Test
    public void addNoteThrowsExceptionWhenItIsPassedNullToInsert() {
        exception.expect(IllegalArgumentException.class);
        service.addNote(null);
    }
}