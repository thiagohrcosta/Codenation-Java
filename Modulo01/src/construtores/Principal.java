package construtores;

import construtores.tarefas.Tarefa;

public class Principal {

    // public => acesso público
    // protected => acesso via herança
    // private => somente acessado na mesma classe

    public static void main(String[] arg){
        System.out.println("Minhas tarefas:");
        System.out.println("-------------------------------");
        Tarefa tarefa1 = new Tarefa("Estudar Java");
        tarefa1.exibirTarefa();
        System.out.println("A tarefa tem " + tarefa1.obterTamanhoTarefa() + " caracteres.");

    }
}
