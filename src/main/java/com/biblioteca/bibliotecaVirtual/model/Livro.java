package com.biblioteca.bibliotecaVirtual.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_livro")
public class Livro {
 
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String titulo;
    public Long anoPublicacao;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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

