package curso.alunos;

public class Aluno {
	// classe é um modelo de Aluno.
	
	private String login;
	
	private String cpf;
	
	private String nome;
	
	public Aluno(String login, String cpf, String nome) {
		this.nome = nome;

		this.login = login;
		this.cpf = cpf;
	}

	public void imprimirDados() {
		System.out.println("Nome: " + nome + ", CPF :" + cpf);
	}
	
	public String getCpf() { return cpf;}
	
	public String getLogin() {return login;}
	
	public void setLogin(String login) {
		if(validateLogin(login)) {
			this.login = login;
		}
		else {
			System.out.println("Login inválido");
		}
	}

}
