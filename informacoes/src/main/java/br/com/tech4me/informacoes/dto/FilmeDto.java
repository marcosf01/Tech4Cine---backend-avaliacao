package br.com.tech4me.informacoes.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import br.com.tech4me.informacoes.model.GeneroFilme;

public class FilmeDto {
    private String id;

    @NotBlank(message = "O título deve possuir caracteres não brancos")
    @NotEmpty(message = "O título deve ser preenchido")
    @Size(min = 3 ,message = "O título deve ter, no mínimo, 3 caracteres")
    private String titulo;

    @Positive
    private Integer ano;
    private GeneroFilme genero;
    private double avaliacaoImdb;
    private String sinopse;
    
    public double getAvaliacaoImdb() {
        return avaliacaoImdb;
    }
    public void setAvaliacaoImdb(double avaliacaoImdb) {
        this.avaliacaoImdb = avaliacaoImdb;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Integer getAno() {
        return ano;
    }
    public void setAno(Integer ano) {
        this.ano = ano;
    }
    public GeneroFilme getGenero() {
        return genero;
    }
    public void setGenero(GeneroFilme genero) {
        this.genero = genero;
    }
    public String getSinopse() {
        return sinopse;
    }
    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    
}
