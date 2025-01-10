package com.aluracurso.challengeLiteratura.repository;

import com.aluracurso.challengeLiteratura.models.Author;
import com.aluracurso.challengeLiteratura.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b LEFT JOIN FETCH b.languages")
    List<Book> findAllWithLanguages();
}
