package com.alura.literalura.entities;


import com.alura.literalura.model.AuthorJson;
import com.alura.literalura.model.LibroJson;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "libro")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "titulo")
    String title;

    @OneToOne(mappedBy = "books", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Author autor;


    @Column(name="idioma")
    private String language;

    @Column(name = "descargas")
    Integer downloads;

    public Book(LibroJson libro) {
        this.title= libro.title();
        this.downloads=libro.download();
        if (!libro.languages().isEmpty()) this.language=libro.languages().get(0);
        if (!libro.autores().isEmpty()) {
            for (AuthorJson authorJson:libro.autores()){
                this.autor=new Author(authorJson);
                break;
            }
        };

    }

}
