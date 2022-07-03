package br.com.tech4me.informacoes.service;

import java.util.List;

import br.com.tech4me.informacoes.dto.FilmeDto;

public interface FilmeService {
    List<FilmeDto> obterTodosOsFilmes();
    FilmeDto obterPorId(String id);
    FilmeDto cadastrarFilme(FilmeDto filme);
    void excluirFilme(String id);
    FilmeDto alterarFilme(String id, FilmeDto filme);
}
