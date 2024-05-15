package com.biblioteca.bibliotecaVirtual.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.bibliotecaVirtual.model.EmprestimoLivro;

@Repository
public interface EmprestimoLivroRepository extends JpaRepository<EmprestimoLivro, Long>{
    
}
