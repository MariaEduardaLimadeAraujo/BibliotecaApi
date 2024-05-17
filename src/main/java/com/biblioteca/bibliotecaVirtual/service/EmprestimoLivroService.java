package com.biblioteca.bibliotecaVirtual.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.bibliotecaVirtual.model.EmprestimoLivro;
import com.biblioteca.bibliotecaVirtual.repositorio.EmprestimoLivroRepository;

@Service
public class EmprestimoLivroService {
   
    @Autowired
    EmprestimoLivroRepository emprestimoLivroRepository;

     public List<EmprestimoLivro> listarEmprestimos() {
        return emprestimoLivroRepository.findAll();
    }

    public EmprestimoLivro cadastrarEmprestimo(EmprestimoLivro emprestimoLivro) {
        return emprestimoLivroRepository.save(emprestimoLivro);
    }

    public EmprestimoLivro atualizarEmprestimo(Long id, EmprestimoLivro emprestimoLivro) {
        if (emprestimoLivroRepository.existsById(id)) {
            emprestimoLivro.setId(id);
            return emprestimoLivroRepository.save(emprestimoLivro);
        } else {
            throw new IllegalArgumentException("O empréstimo de livro com o ID fornecido não existe.");
        }
    }
    
}
