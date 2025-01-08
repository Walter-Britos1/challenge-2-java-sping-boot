package com.aluracurso.challengeLiteratura.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    @Transient
    private List<DataAuthors> authors;
    private List<String> languages;
    @Column(name = "downloads")
    private Double downloads;

    public Book() {
    }

    public Book(DataBook dataBook) {
        this.title = dataBook.title();
        this.authors = dataBook.authors();
        this.languages = dataBook.languages();
        this.downloads = dataBook.downloand();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<DataAuthors> getAuthors() {
        return authors;
    }

    public void setAuthors(List<DataAuthors> authors) {
        this.authors = authors;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public Double getDownloads() {
        return downloads;
    }

    public void setDownloads(Double downloads) {
        this.downloads = downloads;
    }
}

