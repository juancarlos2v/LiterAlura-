package com.alura.literalura.service;

public interface IConvierteDato {

    <T> T ObtenerDatos(String json,Class<T> clase);
}
