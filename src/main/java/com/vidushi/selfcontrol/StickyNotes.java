package com.vidushi.selfcontrol;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class StickyNotes {
    public void setId(Long id) {
        this.id = id;
    }

    @Id
    private Long id;

    public String getContentNotes() {
        return ContentNotes;
    }

    public void setContentNotes(String contentNotes) {
        ContentNotes = contentNotes;
    }

    private String ContentNotes;
}
