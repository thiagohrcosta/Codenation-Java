package disciplinas;

public class MainProcedural {

	public static void main(String[] args) {
		String loginAluno = "meulogin";
		if (validateLogin(loginAluno)) {
			System.out.println("Login Válido");
		}
		else {
			System.out.println("Login Inválido");
		}

	}
	
	private boolean validateLogin(String login, String primeiro nome) {
		return login != null && !login.isEmpty() && login.length() < 20 && login.contains(primeiroNome);
	}

}
