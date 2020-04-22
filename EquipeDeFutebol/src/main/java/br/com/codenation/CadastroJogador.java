package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CadastroJogador {

    private long id;
    private long idTime;
    private String nome;
    private LocalDate dataNascimento;
    private Integer nivelHabilidade;
    private BigDecimal salario;
    private boolean capitao;

    public CadastroJogador(long id,
                           long idTime,
                           String nome,
                           LocalDate dataNascimento,
                           Integer nivelHabilidade,
                           BigDecimal salario) {
        this.id = id;
        this.idTime = idTime;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nivelHabilidade = nivelHabilidade;
        this.salario = salario;
        this.capitao = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdTime() {
        return idTime;
    }

    public void setIdTime(long idTime) {
        this.idTime = idTime;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getNivelHabilidade() {
        return nivelHabilidade;
    }

    public void setNivelHabilidade(Integer nivelHabilidade) {
        this.nivelHabilidade = nivelHabilidade;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public boolean isCapitao() {
        return capitao;
    }

    public void setCapitao(boolean capitao) {
        this.capitao = capitao;
    }

    public Long getIdade(){
        Long idade;
        return idade = Long.valueOf(getDataNascimento().getYear() - LocalDate.now().getYear());
    }
}
