package ArrayListsController;

    // Um array a grosso modo é um meio de juntar variáveis em um meio
    // lógico e mais fácil de ser acessado.

import construtores.tarefas.Tarefa;

public class ArrayTarefas {

    Tarefa[] tarefas;
    int contador = 0;

    public ArrayTarefas(int tamanho){
        this.tarefas = new Tarefa[tamanho];
    }

    public void adicionar(Tarefa tarefa){
        tarefas[contador] = tarefa;
        contador++;
    }

    public void removerTarefa(int posicao){
        tarefas[posicao] = null;
    }

    public void exibirTarefas(){
        for (Tarefa tarefa :tarefas){
            tarefa.exibirTarefa();

        }
    }
}
