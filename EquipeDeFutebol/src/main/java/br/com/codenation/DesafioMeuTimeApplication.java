package br.com.codenation;

import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	List<Time> listarTimes = new ArrayList<>();
	List<Jogador> jogadores = new ArrayList<>();


	// Código do programa =======================================================================

	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {

		checkValidTeam(id);

		listarTimes.add(new Time(
				id,
				nome,
				dataCriacao,
				corUniformePrincipal,
				corUniformeSecundario));
	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {

		checkValidPlayer(id);
		chekValidTeamIdAndLevel(idTime, nivelHabilidade);

		jogadores.add(new Jogador(
				id,
				idTime,
				nome,
				dataNascimento,
				nivelHabilidade,
				salario));
	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {

		Jogador jogador = selectPlayerById(idJogador);

		if(jogador == null){
			throw new JogadorNaoEncontradoException("Player not found.");
		}
		if(idJogador == null){
			throw new NullPointerException();
		}

		Time time = seletTeamById(jogador.getIdTime());
		time.setCapitao(jogador);
	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {
		Time time = seletTeamById(idTime);

		if(time == null){
			throw new TimeNaoEncontradoException("Squad not found.");
		}
		if(idTime == null){
			throw new NullPointerException();
		}
		if(time.getCapitao() == null){
			throw new CapitaoNaoInformadoException("Captain not informed.");
		}
		return time.getCapitao().getId();
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {
		Jogador jogador = selectPlayerById(idJogador);

		if (jogador == null){
			throw new JogadorNaoEncontradoException("Player not found");
		}
		if (idJogador == null){
			throw new NullPointerException();
		}
		return jogador.getNome();
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {
		Time time = seletTeamById(idTime);

		if(time == null){
			throw new TimeNaoEncontradoException("Squad not found.");
		}
		if(idTime == null){
			throw new NullPointerException();
		}
		return time.getNome();
	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {
		Time time = seletTeamById(idTime);

		if(time == null){
			throw new TimeNaoEncontradoException("Squad not found.");
		}
		if(idTime == null){
			throw new NullPointerException();
		}

		List<Jogador> jogadores = selectPLayersBySquad(idTime);

		return jogadores.stream()
				.sorted(Comparator.comparing(Jogador::getId))
				.map(Jogador::getId)
				.collect(Collectors.toList());
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {
		Time time = seletTeamById(idTime);

		if(time == null){
			throw new TimeNaoEncontradoException("Squad not found.");
		}
		if(idTime == null){
			throw new NullPointerException();
		}

		List<Jogador> listaJogador = selectPLayersBySquad(idTime);

		Jogador melhorJogador = Collections.max(listaJogador, Comparator.comparingInt(Jogador::getNivelHabilidade));

		return melhorJogador.getId();
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {
		Time time = seletTeamById(idTime);

		if(time == null){
			throw new TimeNaoEncontradoException("Squand not found.");
		}
		if(idTime == null){
			throw new NullPointerException();
		}

		List<Jogador> listaJogador = selectPLayersBySquad(idTime);

		return listaJogador.stream()
				.sorted(Comparator.comparingLong(Jogador::getId))
				.min(Comparator.comparing(Jogador::getDataNascimento)).get().getId();
	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
		return listarTimes.stream()
				.sorted(Comparator.comparingLong(Time::getId))
				.map(Time::getId)
				.collect(Collectors.toList());
	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {
		Time time = seletTeamById(idTime);

		if(time == null){
			throw new TimeNaoEncontradoException("Squad not found.");
		}
		if(idTime == null){
			throw new NullPointerException();
		}
		return	selectPLayersBySquad(idTime).stream()
				.sorted(Comparator.comparingLong(Jogador::getId))
				.max(Comparator.comparing(Jogador::getSalario)).get().getId();
	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		Jogador jogador = selectPlayerById(idJogador);

		if (jogador == null){
			throw new JogadorNaoEncontradoException("Player not found.");
		}
		if (idJogador == null){
			throw new NullPointerException();
		}
		return jogador.getSalario();
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {

		if(top == null)
			throw new NullPointerException();

		return jogadores.stream()
				.sorted(Comparator.comparing(Jogador::getNivelHabilidade)
						.reversed()
						.thenComparing(Jogador::getId))
				.limit(top)
				.map(Jogador::getId)
				.collect(Collectors.toList());
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {

		Time selectTimeDaCasa = seletTeamById(timeDaCasa);
		Time selectTimeVisitante = seletTeamById(timeDeFora);

		if(selectTimeDaCasa == null || selectTimeVisitante == null)
			throw new TimeNaoEncontradoException("Squad not found.");

		if (timeDaCasa == null || timeDeFora == null)
			throw new NullPointerException();

		if(selectTimeDaCasa.getCorUniformePrincipal().equals(selectTimeVisitante.getCorUniformePrincipal())){
			return selectTimeVisitante.getCorUniformeSecundario();
		} else {
			return selectTimeVisitante.getCorUniformePrincipal();
		}

	}

	// Métodos auxiliares =======================================================================

	public Time seletTeamById(Long timeId){
		return listarTimes.stream().filter(time -> time.getId().equals(timeId)).findAny().orElse(null);
	}

	public Jogador selectPlayerById(Long jogadorId) {
		return jogadores.stream().filter(jogador -> jogador.getId().equals(jogadorId)).findAny().orElse(null);
	}

	public List<Jogador> selectPLayersBySquad(Long timeId){
		return jogadores.stream().filter(jogador -> jogador.getIdTime().equals(timeId)).collect(Collectors.toList());
	}

	// Validadores =======================================================================

	public Long checkValidTeam(Long id){
		if(seletTeamById(id) != null){
			throw new IdentificadorUtilizadoException("This ID was already been taken.");
		}
		else{
			return id;
		}
	}

	public Long chekValidTeamIdAndLevel(Long idTime, Integer nivelHabilidade){
		if (seletTeamById(idTime) == null){
			throw new TimeNaoEncontradoException("Can´t find this ID.");
		}
		if(nivelHabilidade < 0 || nivelHabilidade > 100){
			throw new InvalidParameterException("Wrong input number, must be between 0 and 100.");
		}
		else {
			return idTime;
		}
	}

	public Long checkValidPlayer(Long id) {
		if (selectPlayerById(id) != null) {
			throw new IdentificadorUtilizadoException("This ID was already been taken.");
		} else {
			return id;
		}
	}
}