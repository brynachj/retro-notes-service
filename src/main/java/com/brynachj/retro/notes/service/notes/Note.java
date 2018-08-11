package com.brynachj.retro.notes.service.notes;

import java.util.Date;

/**
 * Created by brynach on 11/08/2018.
 */
public class Note {

    String title;
    String content;
    Date date;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
