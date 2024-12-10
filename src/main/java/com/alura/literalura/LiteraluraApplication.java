package com.alura.literalura;

import com.alura.literalura.entities.Book;
import com.alura.literalura.model.AuthorJson;
import com.alura.literalura.model.LibroJson;
import com.alura.literalura.model.Response;
import com.alura.literalura.repositories.AuthorRepository;
import com.alura.literalura.repositories.BookRepository;
import com.alura.literalura.service.AuthorService;
import com.alura.literalura.service.BookService;
import com.alura.literalura.service.ConsumoAPI;
import com.alura.literalura.service.ConvertirDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public static void main(String[] args) {
        SpringApplication.run(LiteraluraApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        String menu = """ 
                ===== Menú de opciones =====
                1: Buscar libro por título
                2: Listar libros registrados
                3: Listar autores registrados
                4: Consultar autores vivos por año
                """;

        System.out.println(menu);
        Scanner scanner = new Scanner(System.in);

        BookService bookService = new BookService(bookRepository);
        AuthorService authorService = new AuthorService(authorRepository);

        while (true) {
            if (scanner.hasNextInt()) {
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Bucar Libro por Titulo");
                        scanner.nextLine();
                        String search = scanner.nextLine();
                        bookService.addBookByTitle(search);
                        break;
                    case 2:
                        bookService.getBooks();
                        break;
                    case 3:
                        authorService.getAuthors();
                        break;
                    case 4:
                        scanner.nextLine();
                        System.out.println("Buscar Autor por año de nacimiento:");
                        int year = scanner.nextInt();
                        authorService.getAuthorByYear(year);
                }
                // Si llegamos aquí, se seleccionó una opción válida, entonces salimos del bucle
                break;
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next();
            }
        }
    }
}
