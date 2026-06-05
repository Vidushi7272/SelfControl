package com.vidushi.selfcontrol.Controller;
import com.vidushi.selfcontrol.Service.NotesService;
import com.vidushi.selfcontrol.StickyNotes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotesController {
    private final NotesService service;
    NotesController(NotesService service){
        this.service=service;
    }
    @GetMapping("/Notes")
    String retrieveContent(){
        return service.retrieveContent();
    }
    @PutMapping("/Notes")
    String SaveContent(@RequestBody StickyNotes notes)
    {
     return service.saveContent(notes);
    }
}
