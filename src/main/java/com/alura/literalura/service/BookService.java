package com.alura.literalura.service;

import com.alura.literalura.entities.Author;
import com.alura.literalura.entities.Book;
import com.alura.literalura.model.AuthorJson;
import com.alura.literalura.model.LibroJson;
import com.alura.literalura.model.Response;
import com.alura.literalura.repositories.BookRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

public class BookService {

    ConsumoAPI consumoAPI = new ConsumoAPI();
    ConvertirDatos conversor = new ConvertirDatos();

    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void getBooks() {
        System.out.println("Cargando libros...");
        List<Book> books= bookRepository.findAll();
        for (Book book : books) {
            System.out.println(book.getTitle());
        }
    }

    public void addBookByTitle(String title) {
        System.out.println("Cargando Resultados...");
        String request = "https://gutendex.com/books/?search=";
        String search = title.replace(" ", "%20");

        var data = consumoAPI.getData(request + search);
        var libro = conversor.ObtenerDatos(data , Response.class);

        LibroJson librojson= libro.results().get(0);
        Book book = new Book(librojson);

        bookRepository.save(book);
        System.out.println("======Libro guardado======");
        System.out.println(librojson);
    }
}
