package br.com.tech4me.informacoes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.informacoes.model.Filme;

public interface FilmeRepository extends MongoRepository<Filme, String> {
    
}
