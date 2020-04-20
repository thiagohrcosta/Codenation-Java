package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	private CadastroTime equipe;
	private CadastroJogador jogador;

	private List<CadastroTime> listarEquipes = new ArrayList<CadastroTime>();
	private List<CadastroJogador>listarJogadores = new ArrayList<>();


	@Desafio("incluirTime")
	public void incluirTime(Long id,
							String nome,
							LocalDate dataCriacao,
							String corUniformePrincipal,
							String corUniformeSecundario)
	{

		if(existeEquipe(id)) throw new br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException();

		else {
			equipe = new CadastroTime (id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
			listarEquipes.add(equipe);
		}
	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id,
							   Long idTime,
							   String nome,
							   LocalDate dataNascimento,
							   Integer nivelHabilidade,
							   BigDecimal salario)
	{

		if(existeJogador(id)) throw new br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException();

		else{
			jogador = new CadastroJogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
		}
	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {
		throw new UnsupportedOperationException();
	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {
		throw new UnsupportedOperationException();
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {
		throw new UnsupportedOperationException();
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {
		throw new UnsupportedOperationException();
	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {
		throw new UnsupportedOperationException();
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {
		throw new UnsupportedOperationException();
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {
		throw new UnsupportedOperationException();
	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
		throw new UnsupportedOperationException();
	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {
		throw new UnsupportedOperationException();
	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		throw new UnsupportedOperationException();
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {
		throw new UnsupportedOperationException();
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
		throw new UnsupportedOperationException();
	}

	private boolean existeEquipe(long id){
		for (CadastroTime team: listarEquipes){
			if (team.getId() == id) return true;
		}
		return  false;
	}

	private boolean existeJogador(long id){
		for (CadastroJogador player: listarJogadores){
			if (player.getId() == id) return true;
		}
		return  false;
	}

}
