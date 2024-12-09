package com.alura.literalura;

import com.alura.literalura.entities.Book;
import com.alura.literalura.model.Response;
import com.alura.literalura.service.BookService;
import com.alura.literalura.service.ConsumoAPI;
import com.alura.literalura.service.ConvertirDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(LiteraluraApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {

        String menu = """ 
                ===== Menú de opciones =====
                1: Consultar libros
                2: Buscar libro por título
                3: Consultar autores
                4: Consultar autores vivos por año
                """;

        System.out.println(menu);
        Scanner scanner = new Scanner(System.in);

        BookService bookService = new BookService();

        while (true) {
            if (scanner.hasNextInt()) {
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Cargando Libros...");
                        Response result = bookService.getBooks("http://gutendex.com/books/?page=1");

                        System.out.println(result.results());
                        boolean nextPage = true;
                        System.out.println("¿Desea consultar la siguiente pagina? y/n");
                        while (nextPage) {
                            String s = scanner.next();
                            if (s.equals("y")) {
                                System.out.println("Cargando siguiente pagina...");
                                Response response = bookService.getBooks(result.next());
                                System.out.println(response.results());
                                System.out.println("¿Desea consultar la siguiente pagina? y/n");
                            } else {
                                System.out.println("Hasta Pronto!");
                                nextPage = false;
                            }
                        }
                        break;
                    case 2:
                        scanner.nextLine();
                        System.out.println("Bucar Libro por Titulo");
                        String search = scanner.nextLine();
                        String searchEncoded = search.replace(" ", "%20");

                        System.out.println("Buscando libro...");
                        bookService.getBookByTitle(searchEncoded);

                        break;
                }
                // Si llegamos aquí, se seleccionó una opción válida, entonces salimos del bucle
                break;
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next();
            }
        }


//        while (true) {
//
//

//
//            if (scanner.hasNextInt()) {
//                int opcion = scanner.nextInt();
//
//                switch (opcion) {
//                    case 1:
//                        System.out.println("Consultando libros...");
//
//                        System.out.println(results);
//
//                        break;
//
//                    case 2:
//                        // Acción para buscar libro por título
//                        System.out.println("Buscando libro por título...");
//                        break;
//                    case 3:
//                        // Acción para consultar autores
//                        System.out.println("Consultando autores...");
//                        break;
//                    case 4:
//                        // Acción para consultar autores vivos por año
//                        System.out.println("Consultando autores vivos por año...");
//                        break;
//                    default:
//                        // Opción no válida, continuar el bucle
//                        System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
//                        continue;
//                }
//                // Si llegamos aquí, se seleccionó una opción válida, entonces salimos del bucle
//                break;
//            } else {
//
//                System.out.println("Entrada no válida. Por favor, ingrese un número.");
//                scanner.next();
//            }
//        }


    }
}
