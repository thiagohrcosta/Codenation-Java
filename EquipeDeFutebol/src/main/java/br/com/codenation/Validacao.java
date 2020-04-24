package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Validacao {

    public static boolean validarId(long id) {
        if (id <= 0) {
            return false;
        } else return true;
    }

    public static boolean validarNome(String nome) {
        if (nome.isEmpty()) {
            return false;
        } else return true;
    }

    public static boolean validarData(LocalDate data){
        LocalDate dataBase = LocalDate.of(1500,01,01);
        if(data.isBefore(dataBase)){
            return false;
        }
        if(data.isAfter(LocalDate.now())){
            return false;
        }
        else{
            return true;
        }
    }

    public static boolean validarCorUniformePrincipal(String corUniformePrincipal, String corUniformeSecundario){
        if(corUniformePrincipal.isEmpty()){
            return false;
        }
        if(corUniformePrincipal.equalsIgnoreCase(corUniformeSecundario)){
            return false;
        }
        else{
            return true;
        }
    }

    public static boolean validarCorUniformeSecundario(String corUniformePrincipal, String corUniformeSecundario){
        if(corUniformeSecundario.isEmpty()){
            return false;
        }
        if(corUniformeSecundario.equalsIgnoreCase(corUniformePrincipal)){
            return false;
        }
        else{
            return true;
        }
    }

    public static boolean validarTime(CadastroTime time){
        if(!validarId(time.getId())){
            return false;
        }
        if(!validarNome(time.getNome())){
            return false;
        }
        if(!validarData(time.getDate())){
            return false;
        }
        if(!validarCorUniformePrincipal(time.getCorUniformePrincipal(), time.getCorUniformeSecundario())){
            return false;
        }
        if(!validarCorUniformeSecundario(time.getCorUniformeSecundario(), time.getCorUniformePrincipal())){
            return false;
        }
        else return true;
    }

    public static boolean validarNivelHabilidade(Integer nivelHabilidade){
        if(nivelHabilidade < 0 && nivelHabilidade > 100){
            return false;
        }
        else{
            return true;
        }
    }

    public static boolean validarSalario(BigDecimal salario){
        double valorSalario = salario.doubleValue();
        if(valorSalario <= 0.0){
            return false;
        }
        else{
            return true;
        }
    }

    public static boolean validarJogador(CadastroJogador jogador){
        if(!validarId(jogador.getId())){
            return false;
        }
        if(!validarNome(jogador.getNome())){
            return false;
        }
        if(!validarData(jogador.getDataNascimento())){
            return false;
        }
        if(!validarNivelHabilidade(jogador.getNivelHabilidade())){
            return false;
        }
        if(!validarSalario(jogador.getSalario())){
            return false;
        }
        else{
            return true;
        }
    }

}