package com.biblioteca.bibliotecaVirtual.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.bibliotecaVirtual.model.EmprestimoLivro;

public interface EmprestimoLivroRepository extends JpaRepository<EmprestimoLivro, Long>{
    
}
