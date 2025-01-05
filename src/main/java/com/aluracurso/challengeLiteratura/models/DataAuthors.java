package com.aluracurso.challengeLiteratura.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataAuthors(
        String name,
        @JsonAlias("birth_year") String birthYear
) {
}
