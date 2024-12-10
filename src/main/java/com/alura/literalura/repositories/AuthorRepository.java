package com.alura.literalura.repositories;

import com.alura.literalura.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository  extends JpaRepository<Author, Long> {

    List<Author> findByFechaNacimiento(int fechaNacimiento);
}
