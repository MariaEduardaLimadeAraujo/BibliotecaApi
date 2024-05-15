package com.biblioteca.bibliotecaVirtual.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity(name = "livro")
@Table(name = "tb_livro")
public class Livro {
 
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "titulo", nullable = true, length = 100)
    private String titulo;

    @Column(name = "ano_publicacao", nullable = false)
    private Long anoPublicacao;
    
    public Long getId() {
        return id;
    }
   
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Long getAnoPublicacao() {
        return anoPublicacao;
    }
    public void setAnoPublicacao(Long anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
}

