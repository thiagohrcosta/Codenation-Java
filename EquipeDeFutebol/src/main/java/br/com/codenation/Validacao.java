package br.com.codenation;

public class Validacao {

    public static boolean validarId(long id){
        if(id <=0){
            return false;
        }
        else return true;
    }

    public static boolean validarNome(String nome){
        if(nome.isEmpty()){
            return false;
        }
        else return true;
    }
}
