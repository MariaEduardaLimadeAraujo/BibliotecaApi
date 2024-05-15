package com.biblioteca.bibliotecaVirtual.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.biblioteca.bibliotecaVirtual.model.Livro;
import com.biblioteca.bibliotecaVirtual.repositorio.LivroRepository;
import java.util.List;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> listarLivros(){
        return this.livroRepository.findAll();
    }

    public Livro criarLivro(Livro novoLivro){
        return this.livroRepository.save(novoLivro);
    }
}
