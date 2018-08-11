package com.brynachj.retro.notes.service.consent;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by brynach on 11/08/2018.
 */
@Document
public class ConsentDocument{

    String version;
    String content;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ConsentDocument{" +
                "version='" + version + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
