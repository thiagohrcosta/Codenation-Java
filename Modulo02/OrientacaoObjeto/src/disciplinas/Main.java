package disciplinas;

import curso.alunos.Aluno;

public class Main {

	public static void main(String[] args) {
		
		Aluno aluno1 = new Aluno("meulogin", "192.000.000-60", "Teste da Silva");
		aluno1.imprimirDados();
		Aluno aluno2 = new Aluno("meulogin2", "182.222.226-60", "Teste de Souza");
		aluno2.imprimirDados();
	}

}
