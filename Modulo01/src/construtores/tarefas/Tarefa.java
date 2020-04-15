package construtores.tarefas;

public class Tarefa {
    // Podemos definir métodos como comportamentos.

    String descricao;

    public Tarefa(String descricao){
        this.descricao = descricao;
    }

    public void exibirTarefa(){
        System.out.println(descricao);
    }

    public int obterTamanhoTarefa(){
        return descricao.length();
    }

}
