package com.alura.literalura.entities;

import com.alura.literalura.model.AuthorJson;
import com.alura.literalura.model.LibroJson;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Autor")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer fechaNacimiento;
    private Integer fechaFallecimiento;
    @OneToOne
    @JoinTable(
            name = "libro",
            joinColumns = @JoinColumn(name = "autor_id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private Book books;

    public Author(AuthorJson autor) {
        this.nombre= autor.name();
        if (autor.birthYear() == null)
            this.fechaNacimiento = 1980;
        else
            this.fechaNacimiento = autor.birthYear();

        if (autor.deathYear() == null)
            this.fechaFallecimiento = 3022;
        else
            this.fechaFallecimiento = autor.deathYear();
    }

}
