package ArrayListsController;

import construtores.tarefas.Tarefa;

import java.util.ArrayList;

public class ListaTarefas {

    ArrayList<Tarefa> taferas = new ArrayList<>();

    public void adicionar(Tarefa tarefa){
        this.taferas.add(tarefa);
    }

    public void remover(int posicao){
        this.taferas.remove(posicao);
    }

    public void exibirTarefas(){
        for (Tarefa tarefa: taferas){
            tarefa.exibirTarefa();
        }
    }
}
