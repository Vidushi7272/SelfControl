package com.vidushi.selfcontrol.repository;
import com.vidushi.selfcontrol.StickyNotes;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotesRepository extends JpaRepository<StickyNotes,Long> {
}
