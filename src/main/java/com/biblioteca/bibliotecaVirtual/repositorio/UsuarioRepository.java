package com.biblioteca.bibliotecaVirtual.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import com.biblioteca.bibliotecaVirtual.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
