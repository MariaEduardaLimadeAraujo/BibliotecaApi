package com.biblioteca.bibliotecaVirtual.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity(name = "emprestimoLivro")
@Table(name = "tb_emprestimo_livro")
public class EmprestimoLivro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idLivro;
    private Long idUsuario;

    @Column(name = "data_de_entrega", nullable = false)
    private LocalDate dataDeEntrega;

    @Column(name = "entrega_realizada", nullable = false)
    private boolean entregaRealizada;
  
    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
  
    public Long getIdLivro() {
        return idLivro;
    }
   
    public Long getIdUsuario() {
        return idUsuario;
    }
   
    public LocalDate getDataDeEntrega() {
        return dataDeEntrega;
    }
    public void setDataDeEntrega(LocalDate dataDeEntrega) {
        this.dataDeEntrega = dataDeEntrega;
    }
    public boolean isEntregaRealizada() {
        return entregaRealizada;
    }
    public void setEntregaRealizada(boolean entregaRealizada) {
        this.entregaRealizada = entregaRealizada;
    }
    
}

