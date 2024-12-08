package com.alura.literalura;

import com.alura.literalura.service.ConsumoAPI;
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

        //var consumoAPI = new ConsumoAPI();
        //var json= consumoAPI.getData("http://gutendex.com/books/?page=1");
        System.out.println("====LiterAlura====");
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("===== Menú de opciones =====");
            System.out.println("1: Consultar libros");
            System.out.println("2: Buscar libro por título");
            System.out.println("3: Consultar autores");
            System.out.println("4: Consultar autores vivos por año");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) {
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        // Acción para consultar libros
                        System.out.println("Consultando libros...");
                        break;
                    case 2:
                        // Acción para buscar libro por título
                        System.out.println("Buscando libro por título...");
                        break;
                    case 3:
                        // Acción para consultar autores
                        System.out.println("Consultando autores...");
                        break;
                    case 4:
                        // Acción para consultar autores vivos por año
                        System.out.println("Consultando autores vivos por año...");
                        break;
                    default:
                        // Opción no válida, continuar el bucle
                        System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
                        continue;
                }
                // Si llegamos aquí, se seleccionó una opción válida, entonces salimos del bucle
                break;
            } else {

                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next();
            }
        }


        //System.out.println(json);


        //opciones de insercion y consulta de libros

        //busqueda de libro por titulo

        //lista de todos los libros

    }
}
