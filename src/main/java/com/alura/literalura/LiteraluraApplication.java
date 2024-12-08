package com.alura.literalura;

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

        System.out.println("====Alura Challenge===");
        Scanner scan = new Scanner(System.in);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://gutendex.com/books"))
                .build();
        System.out.println("Enviando solicitud...");
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());


        //opciones de insercion y consulta de libros

        //busqueda de libro por titulo

        //lista de todos los libros

    }
}
