package br.com.tech4me.informacoes.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.informacoes.dto.FilmeDto;
import br.com.tech4me.informacoes.model.Filme;
import br.com.tech4me.informacoes.repository.FilmeRepository;

@Service
public class FilmeServiceImpl implements FilmeService {

    @Autowired
    private FilmeRepository repository;

    private ModelMapper mapper = new ModelMapper();

    @Override
    public List<FilmeDto> obterTodosOsFilmes() {
        List<Filme> filmes = repository.findAll();

        return filmes.stream()
        .map(f -> mapper.map(f, FilmeDto.class))
        .collect(Collectors.toList());
    }

    @Override
    public FilmeDto obterPorId(String id) {
        Optional<Filme> filme = repository.findById(id);

        if (filme.isPresent()) {
            return mapper.map(filme, FilmeDto.class);
        }
        return null;
    }

    @Override
    public FilmeDto cadastrarFilme(FilmeDto filme) {
        Filme salvarUsuario = mapper.map(filme, Filme.class);
        repository.save(salvarUsuario);
        return mapper.map(salvarUsuario, FilmeDto.class);
    }

    @Override
    public void excluirFilme(String id) {
        repository.deleteById(id);
        
    }

    @Override
    public FilmeDto alterarFilme(String id, FilmeDto filme) {
        Optional<Filme> filmeBuscar = repository.findById(id);
        
        if (filmeBuscar.isPresent()) {
            Filme filmeAlterar = mapper.map(filme, Filme.class);
            filmeAlterar.setId(id);
            filmeAlterar = repository.save(filmeAlterar);
            return mapper.map(filmeAlterar, FilmeDto.class);
        }
        return null;
    
    }
    
}
