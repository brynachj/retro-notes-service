package com.brynachj.retro.notes.service.consent;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by brynach on 11/08/2018.
 */
public class ConsentDocumentServiceTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @InjectMocks
    ConsentDocumentService service;

    @Mock
    ConsentDocumentRepository consentDocumentRepository;

    ConsentDocument consentDocument;
    List<ConsentDocument> consentDocumentList;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        consentDocument = new ConsentDocument();
        consentDocument.setVersion("1");
        consentDocument.setContent("content");

        consentDocumentList = new ArrayList<>();
    }

    @Test
    public void getLatestConsentDocumentThrowsAnIndexOutOfBoundExceptionWhenEmptyListIsReturnedFromTheRepository() {
        exception.expect(IndexOutOfBoundsException.class);

        service.getLatestConsentDocument();
    }

    @Test
    public void getLatestConsentDocumentReturnsTheCorrectDocumentWhenASingleDocumentIsReturnedFromRepository() {
        consentDocumentList.add(consentDocument);
        when(consentDocumentRepository.findAll()).thenReturn(consentDocumentList);

        assertEquals(consentDocument, service.getLatestConsentDocument());
    }


    @Test
    public void getLatestConsentDocumentReturnsTheCorrectDocumentBasedOnVersionOrderingWhenMultipleAreReturnedFromRepository() {
        ConsentDocument consentDocument1 = new ConsentDocument();
        consentDocument1.setContent("more content");
        consentDocument1.setVersion("2");
        consentDocumentList.add(consentDocument);
        consentDocumentList.add(consentDocument1);
        when(consentDocumentRepository.findAll()).thenReturn(consentDocumentList);

        assertEquals(consentDocument1, service.getLatestConsentDocument());
    }

    @Test
    public void addConsentDocumentCallsConsentDocumentRepositoryInsertWithTheSuppliedConsentDocument() {
        service.addConsentDocument(consentDocument);

        verify(consentDocumentRepository, times(1)).insert(consentDocument);
    }

    @Test
    public void addConsentDocumentThrowsExceptionWhenItIsPassedNullToInsert() {
        exception.expect(IllegalArgumentException.class);
        service.addConsentDocument(null);
    }

}