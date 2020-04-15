package ArrayListsController;

import construtores.tarefas.Tarefa;

public class PrincipalArray {

    public static void main(String[] args) {
        System.out.println("Minhas Tarefas");
        System.out.println("-----------------------");
        ArrayTarefas tarefas = new ArrayTarefas(3);
        Tarefa tarefa1 = new Tarefa("Estudar Java");
        Tarefa tarefa2 = new Tarefa("Trabalhar");
        Tarefa tarefa3 = new Tarefa("Estudar para o Codenation");

        tarefas.adicionar(tarefa1);
        tarefas.adicionar(tarefa2);
        tarefas.adicionar(tarefa3);

        tarefas.exibirTarefas();


    }
}
