package com.brynachj.retro.notes.service.consent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by brynach on 11/08/2018.
 */
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ConsentDocumentDocumentControllerTest {

    @InjectMocks
    private ConsentDocumentController controller;

    @Mock
    private ConsentDocumentService consentDocumentService;

    @Test
    public void getConsentReturnsAConsentObject() {
        when(consentDocumentService.getLatestConsentDocument()).thenReturn(new ConsentDocument());

        assertTrue(controller.getConsent().getClass() == ConsentDocument.class);
    }

    @Test
    public void getConsentCallsConsentService() {
        controller.getConsent();

        verify(consentDocumentService, times(1)).getLatestConsentDocument();
    }

    @Test
    public void postConsentDocumentCallsConsentDocumentService() {
        ConsentDocument consentDocument = new ConsentDocument();
        controller.postConsentDocument(consentDocument);

        verify(consentDocumentService, times(1)).addConsentDocument(consentDocument);
    }
}