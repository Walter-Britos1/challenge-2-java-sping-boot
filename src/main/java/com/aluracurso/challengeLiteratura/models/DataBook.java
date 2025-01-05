package com.aluracurso.challengeLiteratura.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataBook(
        String title,
        List<DataAuthors> authors,
        List<String> languages,
        @JsonAlias("download_count") Double downloand
) {
    @Override
    public String toString() {
        return  "title: " + title +
                "authors: " + authors +
                "languages: " + languages +
                "downloand: " + downloand;
    }
}
