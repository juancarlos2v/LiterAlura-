package com.alura.literalura.model;

import com.alura.literalura.entities.Author;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LibroJson(
        @JsonAlias("id") Long id,
        @JsonAlias("title") String title,
        @JsonAlias("authors") List<AuthorJson> autores,
        @JsonAlias("languages") List<String> languages,
        @JsonAlias("download_count") Integer download
) {
}
