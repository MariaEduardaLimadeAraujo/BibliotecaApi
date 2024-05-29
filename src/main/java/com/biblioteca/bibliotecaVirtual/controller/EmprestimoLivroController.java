package com.biblioteca.bibliotecaVirtual.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.bibliotecaVirtual.model.EmprestimoLivro;
import com.biblioteca.bibliotecaVirtual.service.EmprestimoLivroService;

@RestController
@RequestMapping("/biblioteca")
public class EmprestimoLivroController {
    
    @Autowired
    EmprestimoLivroService emprestimoLivroService;

    @GetMapping("/emprestimos")
    public ResponseEntity<List<EmprestimoLivro>> listarEmprestimos() throws Exception {
        List<EmprestimoLivro> emprestimos = emprestimoLivroService.listarEmprestimos();
        return ResponseEntity.ok().body(emprestimos);
    }

    @PostMapping("/emprestimos")
    public ResponseEntity<String> cadastrarEmprestimo(@RequestBody EmprestimoLivro emprestimoLivro) throws Exception {
        String resultado = emprestimoLivroService.cadastroEmprestimo(emprestimoLivro);

        if (resultado.contains("Atenção")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultado);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmprestimoLivro> atualizarEmprestimo(@PathVariable Long id, @RequestBody EmprestimoLivro emprestimoLivro) {
        EmprestimoLivro emprestimoAtualizado = emprestimoLivroService.atualizarEmprestimo(id, emprestimoLivro);
        return ResponseEntity.ok().body(emprestimoAtualizado);
    }
}
