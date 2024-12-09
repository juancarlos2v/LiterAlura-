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
        String request = "https://gutendex.com/books/?search=";
        String search = title.replace(" ", "%20");
        System.out.println(request+title);
        var data = consumoAPI.getData(request+search);

        Response response = conversor.ObtenerDatos(data,Response.class);

        return response;
    }
}
