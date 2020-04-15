package ArrayListsController;

import construtores.tarefas.Tarefa;

public class PrincipalArray {

    public static void main(String[] args) {
        System.out.println("Minhas Tarefas");
        System.out.println("-----------------------");

        ListaTarefas tarefas = new ListaTarefas();

        Tarefa tarefa1 = new Tarefa("Estudar Java");
        Tarefa tarefa2 = new Tarefa("Trabalhar");
        Tarefa tarefa3 = new Tarefa("Estudar para o Codenation");
        Tarefa tarefa4 = new Tarefa("Estudar para dois AceleraDev ao mesmo tempo, seria possível?");

        tarefas.adicionar(tarefa1);
        tarefas.adicionar(tarefa2);
        tarefas.adicionar(tarefa3);
        tarefas.adicionar(tarefa4);

        tarefas.exibirTarefas();

        tarefas.remover(tarefa4);

        System.out.println("Minhas tarefas após remover:");
        System.out.println("-----------------------");

        tarefas.exibirTarefas();




    }
}
