package com.brynachj.retro.notes.service.consent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by brynach on 11/08/2018.
 */
@RestController
@RequestMapping("consent")
public class ConsentDocumentController {

    @Autowired
    private ConsentDocumentService consentDocumentService;

    @RequestMapping("/latest")
    public ConsentDocument getConsent() {
        return consentDocumentService.getLatestConsentDocument();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void postConsentDocument(@RequestBody ConsentDocument consentDocument) {
        consentDocumentService.addConsentDocument(consentDocument);
    }

}
