package com.alura.literalura.model;

import com.alura.literalura.entities.Book;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Response(
        @JsonAlias("count") int count,
        @JsonAlias("next") String next,
        @JsonAlias("previous") String previous,
        @JsonAlias("results") List<LibroJson> results
) {
}
