package com.alura.literalura.entities;


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
    private Long id;
    @JsonProperty("title")
    @Column(name = "titulo")
    private String title;
    @JsonProperty("authors")
    @Column(name = "autor")
    private String author;
    @Column(name="idioma")
    private String language;
    @Column(name = "descargas")
    private Integer downloads;

}
