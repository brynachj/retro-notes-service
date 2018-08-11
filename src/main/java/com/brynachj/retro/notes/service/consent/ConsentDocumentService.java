package com.brynachj.retro.notes.service.consent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

/**
 * Created by brynach on 11/08/2018.
 */
@Service
public class ConsentDocumentService {

    @Autowired
    private ConsentDocumentRepository consentDocumentRepository;

    public ConsentDocument getLatestConsentDocument() {
        List<ConsentDocument> consentDocuments = consentDocumentRepository.findAll();
        consentDocuments.sort(Comparator.comparing(ConsentDocument::getVersion));
        return consentDocuments.get(consentDocuments.size()-1);
    }

    public void addConsentDocument(ConsentDocument consentDocument) {
        if(consentDocument == null){
            throw new IllegalArgumentException("Tried to insert null consent document");
        }
        consentDocumentRepository.insert(consentDocument);
    }
}
