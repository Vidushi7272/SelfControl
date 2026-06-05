package com.vidushi.selfcontrol.Service;

import com.vidushi.selfcontrol.StickyNotes;
import com.vidushi.selfcontrol.repository.NotesRepository;
import org.springframework.stereotype.Service;

@Service
public class NotesService {
private final NotesRepository repo;
NotesService(NotesRepository repo){ 
    this.repo= repo;
}
    public String retrieveContent(){
    return repo.findById(1L).orElseThrow().getContentNotes();
    }
    public String saveContent(StickyNotes notes){
    return repo.save(notes).getContentNotes();
    }
}
