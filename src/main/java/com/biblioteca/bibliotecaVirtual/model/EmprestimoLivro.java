package com.biblioteca.bibliotecaVirtual.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_emprestimo_livro")
public class EmprestimoLivro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name ="livro_id", nullable = true, referencedColumnName = "id")
    private Livro livro;

    @ManyToOne
    @JoinColumn(name ="usuario_id", nullable = true, referencedColumnName = "id")
    private Usuario usuario;

    @Column(name = "data_de_entrega", nullable = false)
    private LocalDate dataDeEntrega;

    @Column(name = "entrega_realizada", nullable = false)
    private boolean entregaRealizada;

    public EmprestimoLivro(){}
  
    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
  
    public Usuario getUsuario() {
        return usuario;
    }
   
    public Livro getLivro() {
        return livro;
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

