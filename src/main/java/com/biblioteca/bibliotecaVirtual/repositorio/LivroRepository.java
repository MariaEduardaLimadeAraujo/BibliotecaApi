package com.biblioteca.bibliotecaVirtual.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.bibliotecaVirtual.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository <Livro, Long>{

    
}