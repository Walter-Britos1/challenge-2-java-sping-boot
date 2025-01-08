package com.aluracurso.challengeLiteratura.repository;

import com.aluracurso.challengeLiteratura.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
