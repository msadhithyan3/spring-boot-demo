package com.example.demo.jpa;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class NoteController {
    @Autowired
    private NoteRepository noteRepository;

    @GetMapping("/notes")
    public ResponseEntity getAllNotes() {
        List<Note> noteList = noteRepository.findAll();
        return new ResponseEntity(noteList, HttpStatus.OK);
    }

    @PostMapping("/notes")
    public ResponseEntity createNote(@Valid @RequestBody Note note) {
        Note createdNote = noteRepository.save(note);
        return new ResponseEntity(createdNote, HttpStatus.CREATED);
    }

    @GetMapping("/notes/{id}")
    public ResponseEntity getNoteById(@PathVariable(value = "id") Long noteId) throws ResourceNotFoundException {
        Optional<Note> optionalNote = noteRepository.findById(noteId);
        if (optionalNote.isPresent())
            return new ResponseEntity(optionalNote, HttpStatus.CREATED);
        else
            throw new ResourceNotFoundException("Note not found " + noteId);
    }

    @PutMapping("/notes/{id}")
    public ResponseEntity updateNote(@PathVariable(value = "id") Long noteId, @Valid @RequestBody Note noteDetails) throws ResourceNotFoundException {
        Note note = noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note not found " + noteId));
        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());
        Note updatedNote = noteRepository.save(note);
        return new ResponseEntity(updatedNote, HttpStatus.CREATED);
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) throws ResourceNotFoundException {
        Note note = noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note not found " + noteId));
        noteRepository.delete(note);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/notes/title/{titleName}")
    public ResponseEntity findSelectedTitleNotes(@PathVariable(value = "titleName") String title) {
        Pageable pageable = PageRequest.of(0, 1);
        Page<Note> pageList = noteRepository.findSelectedTitleNotes(title,pageable);
        return new ResponseEntity(pageList.getContent(), HttpStatus.OK);
    }
}
