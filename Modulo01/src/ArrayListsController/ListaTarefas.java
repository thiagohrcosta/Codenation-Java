package ArrayListsController;

import construtores.tarefas.Tarefa;

import java.util.ArrayList;

public class ListaTarefas {

    ArrayList<Tarefa> taferas = new ArrayList<>();

    public void adicionar(Tarefa tarefa){
        if (tarefa != null && tarefa.obterTamanhoTarefa() <= 20){
            this.taferas.add(tarefa);
        }
        else{
            System.out.println("A tarefa é inválida.");
            System.out.println("----------------------");
        }

    }

    public void remover(int posicao){
        if(posicao < this.taferas.size()){
            this.taferas.remove(posicao);
        }
        else {
            System.out.println("Tarefa não existe.");
        }
    }

    public void exibirTarefas(){
        for (Tarefa tarefa: taferas){
            tarefa.exibirTarefa();
        }
    }
}
