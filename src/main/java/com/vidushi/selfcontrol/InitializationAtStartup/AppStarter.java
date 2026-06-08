package com.vidushi.selfcontrol.InitializationAtStartup;
import com.vidushi.selfcontrol.StickyNotes;
import com.vidushi.selfcontrol.repository.NotesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppStarter implements CommandLineRunner {
    private final NotesRepository repo;
    AppStarter(NotesRepository repo){
        this.repo=repo;
    }
    @Override
    public void run(String... args) throws Exception {
     if(repo.existsById(1L)){
         StickyNotes notes= new StickyNotes();
         notes.setContentNotes("");
         notes.setId(1L);
         repo.save(notes);
     }
        }
}
