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

            if (this.usuarioTemLivroNaoDevolvido(usuarioId, livroId)) {
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
        // Implementação do método para verificar se o usuário possui 3 livros não devolvidos.
        List<EmprestimoLivro> emprestimos = emprestimoRepository.findByUsuarioIdAndEntregaRealizadaFalse(usuarioId);
        return emprestimos.size() >= 3;
    }

    private boolean usuarioTemLivroNaoDevolvido(Long usuarioId, Long livroId) {
        List<EmprestimoLivro> emprestimos = emprestimoRepository.findByUsuarioIdAndLivroIdAndEntregaRealizadaFalse(usuarioId, livroId);
        return !emprestimos.isEmpty();
    }
        // Implementação do método para verificar se o usuário já possui um livro específico não devolvido.
    

    public List<EmprestimoLivro> listarEmprestimos() throws Exception {
        try {
            return this.emprestimoRepository.findAll();
        } catch (Exception e) {
            String mensagem = "Erro ao tentar listar empréstimos de livros. " + e.getMessage();
            throw new Exception(mensagem);
        }
    }

    public EmprestimoLivro atualizarEmprestimo(Long id, EmprestimoLivro emprestimoLivro) throws Exception {
        try {
            java.util.Optional<EmprestimoLivro> optionalEmprestimo = emprestimoRepository.findById(id);
            if (optionalEmprestimo.isPresent()) {
                EmprestimoLivro emprestimoExistente = optionalEmprestimo.get();
                if (emprestimoExistente.isEntregaRealizada()) {
                    throw new Exception("O livro já foi entregue anteriormente.");
                } else {
                    emprestimoExistente.setEntregaRealizada(true);
                    emprestimoRepository.save(emprestimoExistente);
                    return emprestimoExistente;
                }
            } else {
                throw new Exception("Empréstimo não encontrado para o ID: " + id);
            }
        } catch (Exception e) {
            String mensagem = "Erro ao tentar atualizar o empréstimo: " + e.getMessage();
            throw new Exception(mensagem);
        }
    }
    
}


