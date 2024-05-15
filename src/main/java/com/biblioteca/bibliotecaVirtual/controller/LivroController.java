package com.biblioteca.bibliotecaVirtual.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.biblioteca.bibliotecaVirtual.model.Livro;
import com.biblioteca.bibliotecaVirtual.service.LivroService;

@RestController
@RequestMapping("/biblioteca")
public class LivroController {
    
    @Autowired
    LivroService livroService;
  
    @GetMapping("/livros")
    public ResponseEntity<List<Livro>>  getAll(){
        List<Livro> livros = this.livroService.listarLivros();
        return ResponseEntity.ok().body(livros);
    }

    @PostMapping("/livros")
    public ResponseEntity<String>  criarLivros(){
        for(Long i = (long) 0; i < 5; i++){
            Livro livro = new Livro();
            livro.setTitulo("Harry Potter");
            livro.setAnoPublicacao(i);
            this.livroService.criarLivro(livro);
        }
        return ResponseEntity.ok().body("Livros criados");
    }
}

