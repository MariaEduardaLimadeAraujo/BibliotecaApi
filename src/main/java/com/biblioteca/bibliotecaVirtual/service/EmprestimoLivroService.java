package com.biblioteca.bibliotecaVirtual.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.bibliotecaVirtual.model.EmprestimoLivro;
import com.biblioteca.bibliotecaVirtual.repositorio.EmprestimoLivroRepository;

@Service
public class EmprestimoLivroService {

    @Autowired
    private EmprestimoLivroRepository emprestimoRepository;

    public String cadastroEmprestimo(EmprestimoLivro emprestimo) throws Exception {
        try {
            if (emprestimo == null) {
                return "Atenção: Usuário deve informar todos os dados do empréstimo";
            }

            Long usuarioId = emprestimo.getUsuario().getId(); // Acessando o ID do usuário
            Long livroId = emprestimo.getLivro().getId(); // Acessando o ID do livro

            if (this.usuarioPossuiTresLivrosEmprestados(usuarioId)) {
                return "Atenção: Usuário já possui 3 livros emprestados.";
            }

            if (this.usuarioTemLivroDevolvido(usuarioId, livroId)) {
                return "Atenção: Usuário já possui este livro emprestado.";
            }

            emprestimoRepository.save(emprestimo);
            return "Empréstimo cadastrado com sucesso.";

        } catch (Exception e) {
            String mensagem = "Erro ao tentar criar empréstimo do livro: " + e.getMessage();
            throw new Exception(mensagem);
        }
    }

    private boolean usuarioPossuiTresLivrosEmprestados(Long usuarioId) {
        return false;
        // Implementação do método para verificar se o usuário possui 3 livros não devolvidos.
    }

    private boolean usuarioTemLivroDevolvido(Long usuarioId, Long livroId) {
        return false;
        // Implementação do método para verificar se o usuário já possui um livro específico não devolvido.
    }

    public List<EmprestimoLivro> listarEmprestimos() throws Exception {
        try {
            return this.emprestimoRepository.findAll();
        } catch (Exception e) {
            String mensagem = "Erro ao tentar listar empréstimos de livros. " + e.getMessage();
            throw new Exception(mensagem);
        }
    }

    public EmprestimoLivro atualizarEmprestimo(Long id, EmprestimoLivro emprestimoLivro) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizarEmprestimo'");
    }
}
  


