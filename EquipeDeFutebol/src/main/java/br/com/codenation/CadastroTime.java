package br.com.codenation;

import java.time.LocalDate;
import java.util.ArrayList;

public class CadastroTime {

    private long id;
    private String nome;
    private LocalDate dataCriaçao;
    private String corUniformePrincipal;
    private String corUniformeSecundario;
    private List<Jogador> jogadores;


    public CadastroTime(long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario){
        this.id = id;
        this.nome = nome;
        this.LocalDate = dataCriacao;
        this.String = corUniformePrincipal;
        this.String = corUniformeSecundario;
        jogadores = new ArrayList<>();

    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public LocalDate getDate(){
        return dataCriaçao;
    }

    public void setDate(LocalDate dataCriaçao){
        this.dataCriaçao = dataCriaçao;
    }

    public String getCorUniformePrincipal(){
        return corUniformePrincipal;
    }

    public String getCorUniformeSecundario(){
        return corUniformeSecundario;
    }


}



