package com.biblioteca.bibliotecaVirtual.repositorio;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.bibliotecaVirtual.model.EmprestimoLivro;

@Repository
public interface EmprestimoLivroRepository extends JpaRepository<EmprestimoLivro, Long>{

    List<EmprestimoLivro> findByUsuarioIdAndEntregaRealizadaFalse(Long usuarioId);

    List<EmprestimoLivro> findByLivroIdAndEntregaRealizadaFalse(Long usuarioId);

    List<EmprestimoLivro> findByUsuarioIdAndLivroIdAndEntregaRealizadaFalse(Long usuarioId, Long livroId);
    
}
