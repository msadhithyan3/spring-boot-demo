package com.example.demo.repository;

import com.example.demo.jpa.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    @Query(value = "select * from notes where title=:title", nativeQuery = true)
    Page<Note> findSelectedTitleNotes(@Param("title") String title, Pageable pageable);
}
