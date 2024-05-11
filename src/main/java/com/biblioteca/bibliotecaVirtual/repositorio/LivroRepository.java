package com.biblioteca.bibliotecaVirtual.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import com.biblioteca.bibliotecaVirtual.model.Livro;

public interface LivroRepository extends JpaRepository <Livro, Long>{

    
}