package com.aluracurso.challengeLiteratura.repository;

import com.aluracurso.challengeLiteratura.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AuthorRpository extends JpaRepository<Author, Long> {
    @Query("SELECT a FROM Author a LEFT JOIN FETCH a.books WHERE a.name = :name")
    List<Author> findByNameWithBooks(@Param("name") String name);

    @Query("""
    SELECT a 
    FROM Author a 
    LEFT JOIN FETCH a.books 
    WHERE 
        a.birthYear IS NOT NULL AND CAST(a.birthYear AS int) <= :year 
        AND (a.deathYear IS NULL OR (a.deathYear IS NOT NULL AND CAST(a.deathYear AS int) >= :year))
""")
    List<Author> findAliveAuthorsByYear(@Param("year") int year);
}
