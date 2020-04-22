package br.com.codenation;

import java.time.LocalDate;

public class CadastroTime {

    private long id;
    private String nome;
    private LocalDate dataCriacao;
    private String corUniformePrincipal;
    private String corUniformeSecundario;

    public CadastroTime(long id,
                        String nome,
                        LocalDate dataCriacao,
                        String corUniformePrincipal,
                        String corUniformeSecundario) {
        this.id = id;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.corUniformePrincipal = corUniformePrincipal;
        this.corUniformeSecundario = corUniformeSecundario;
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
        return dataCriacao;
    }

    public void setDate(LocalDate dataCriacao){
        this.dataCriacao = dataCriacao;
    }

    public String getCorUniformePrincipal(){
        return corUniformePrincipal;
    }

    public void setCorUniformePrincipal(String corUniformePrincipal){
        this.corUniformePrincipal = corUniformePrincipal;
    }

    public String getCorUniformeSecundario(){
        return corUniformeSecundario;
    }

    public void setCorUniformeSecundario(String corUniformeSecundario){
        this.corUniformeSecundario = corUniformeSecundario;
    }
}



