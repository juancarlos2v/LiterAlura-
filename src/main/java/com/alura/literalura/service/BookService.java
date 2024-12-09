package com.alura.literalura.service;

import com.alura.literalura.model.LibroJson;
import com.alura.literalura.model.Response;

import java.util.List;

public class BookService {

    ConsumoAPI consumoAPI = new ConsumoAPI();
    ConvertirDatos conversor=new ConvertirDatos();


    public Response getBooks(String url) {
        //String json = "http://gutendex.com/books/?page=1";
        String data = consumoAPI.getData(url);
        Response results = conversor.ObtenerDatos(data,Response.class);

        //System.out.println("=====PAGINA 1=====");
        return  results;
    }

    public Response getBookByTitle(String title) {
        String request = "http://gutendex.com/books?search=";
        System.out.println(request+title);
        String data = consumoAPI.getData(request+title);

        return conversor.ObtenerDatos(data,Response.class);

    }
}
