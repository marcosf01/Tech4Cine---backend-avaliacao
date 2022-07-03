package br.com.tech4me.informacoes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.informacoes.dto.FilmeDto;
import br.com.tech4me.informacoes.service.FilmeService;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    
    @Autowired
    private FilmeService service;

    @GetMapping
    public List<FilmeDto> obterFilmes() {
        return service.obterTodosOsFilmes();
    }

    @PostMapping
    public ResponseEntity<FilmeDto> cadastrarFilme(@RequestBody @Valid FilmeDto filme ) {
        return new ResponseEntity<>(service.cadastrarFilme(filme), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public FilmeDto obterPorId(@PathVariable String id) {
        return service.obterPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmeDto> alterarFilme(@PathVariable String id, @RequestBody @Valid FilmeDto filme) {
        return new ResponseEntity<>(service.alterarFilme(id, filme), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void excluirFilme(@PathVariable String id) {
        service.excluirFilme(id);
    }
}
