package com.alura.literalura.service;

import com.alura.literalura.entities.Author;
import com.alura.literalura.entities.Book;
import com.alura.literalura.model.AuthorJson;
import com.alura.literalura.model.LibroJson;
import com.alura.literalura.model.Response;
import com.alura.literalura.repositories.AuthorRepository;

import java.util.ArrayList;
import java.util.List;

public class AuthorService {

    ConsumoAPI consumoAPI = new ConsumoAPI();
    ConvertirDatos conversor = new ConvertirDatos();

    AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void getAuthors() {
        System.out.println("Cargando autores...");
        List<Author> authors = authorRepository.findAll();

        for(Author author : authors) {
            System.out.println(author.getNombre());
        }
    }

    public void getAuthorByYear(int year) {
        System.out.println("Cargando autores...");
        List<Author> authors=authorRepository.findByFechaNacimiento(year);

        for(Author author : authors) {
            System.out.println(author.getNombre());
        }
    }
}
