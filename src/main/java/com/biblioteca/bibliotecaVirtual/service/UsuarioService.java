package com.biblioteca.bibliotecaVirtual.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.biblioteca.bibliotecaVirtual.model.Usuario;
import com.biblioteca.bibliotecaVirtual.repositorio.UsuarioRepository;

@Service

public class UsuarioService {
   
    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios(){
        return this.usuarioRepository.findAll();
    }

    public Usuario criarUsuario(Usuario novoUsuario){
        return this.usuarioRepository.save(novoUsuario);
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
