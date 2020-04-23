package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;

import static java.util.stream.Collectors.toList;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	private CadastroTime equipe;
	private CadastroJogador jogador;

	private List<CadastroTime> listarEquipes = new ArrayList<>();
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
			equipe = new CadastroTime (
					id,
					nome,
					dataCriacao,
					corUniformePrincipal,
					corUniformeSecundario);

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
		if(!existeEquipe(id)) throw new br.com.codenation.desafio.exceptions.TimeNaoEncontradoException();

		else{
			jogador = new CadastroJogador(
					id,
					idTime,
					nome,
					dataNascimento,
					nivelHabilidade,
					salario);

			listarJogadores.add(jogador);
		}
	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {

		if(!existeJogador(idJogador)) {
			throw new br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException();
		}
		else {
			for (CadastroJogador player : listarJogadores){
				if(player.getId() == idJogador){
					player.setCapitao(true);
				}
			}
		}
	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {

		List<CadastroJogador> allPlayers;
		Long capitao;

		if(!existeEquipe(idTime)) {
			throw new br.com.codenation.desafio.exceptions.TimeNaoEncontradoException();
		}
		else {
			allPlayers = findPLayer(idTime);
			for (CadastroJogador captain : allPlayers){
				if(captain.isCapitao() == true)
					return capitao = captain.getId();
			}
			throw new br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException();
		}
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {
		String nome="";
		for (CadastroJogador player : listarJogadores){
			if(player.getId()==idJogador){
				nome = player.getNome();
			}
		}
		if(nome.isEmpty() || nome == null){
			throw new br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException();
		}
		else{
			return nome;
		}
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {
		String nome = "";
		for(CadastroTime squad: listarEquipes){
			if(squad.getId()==idTime){
				nome = squad.getNome();
			}
		}
		if(nome.isEmpty() || nome == null){
			throw new br.com.codenation.desafio.exceptions.TimeNaoEncontradoException();
		}
		else{
			return nome;
		}
	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {
		List<CadastroJogador> jogadores;
		List<Long> ids = new ArrayList<>();

		if(!existeEquipe(idTime)){
			throw new br.com.codenation.desafio.exceptions.TimeNaoEncontradoException();
		}
		else {
			jogadores = findPLayer(idTime);
			for(CadastroJogador player: jogadores) {
				ids.add(player.getId());
			}
			return ids;
		}
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {
	    List<CadastroJogador> jogadores;
	    Long bestPlayer;

	    if(!existeEquipe(idTime)) {
	        throw new br.com.codenation.desafio.exceptions.TimeNaoEncontradoException();
        }
	    else {
	        jogadores = findPLayer(idTime);
	        bestPlayer = jogadores
                    .stream()
                    .max(Comparator.comparing(CadastroJogador::getNivelHabilidade)).get().getId();
        }
        return bestPlayer;
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {
		List<CadastroJogador> jogadores;
		Long olderPlayer;

		if(!existeEquipe(idTime)) {
			throw new br.com.codenation.desafio.exceptions.TimeNaoEncontradoException();
		}
		else{
			jogadores = findPLayer(idTime);
			olderPlayer = jogadores.stream()
					.max(Comparator.comparingLong(CadastroJogador::getIdade)).get().getId();
		}
		return olderPlayer;
	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
		List<Long> buscarEquipeId = new LinkedList<>();

		for (CadastroTime findTeam: listarEquipes){
			buscarEquipeId.add(findTeam.getId());
		}
		return  buscarEquipeId;
	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {
        throw new UnsupportedOperationException();
    }


	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador){
	    BigDecimal salario;
	    CadastroJogador playerSalary;

	    if(!existeJogador(idJogador)) {
            throw new JogadorNaoEncontradoException();
        }
	    else{
	        playerSalary = findOnePlayer(idJogador);
	        salario = playerSalary.getSalario();
	        return salario;

	    }
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {
		List<CadastroJogador> topPlayers;
		List<CadastroJogador> topBest;
		List<Long> idTopPlayers = new LinkedList<>();

		if (top<1){
			throw new UnsupportedOperationException();
		}
		else{
			topPlayers = listarJogadores
                    .stream()
                    .sorted(Comparator.comparingInt(CadastroJogador::getNivelHabilidade)).collect(toList());
			topBest = topPlayers.subList(0,top);

			for (CadastroJogador findTopPlayers: topBest){
				idTopPlayers.add(findTopPlayers.getId());
			}
			return idTopPlayers;
		}
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {

		if(!existeEquipe(timeDaCasa) || !existeEquipe(timeDeFora)) throw new TimeNaoEncontradoException();

		String corPrimariaCasa = findTeam(timeDaCasa).getCorUniformePrincipal();
		String corPrimariaFora = findTeam(timeDeFora).getCorUniformePrincipal();
		String corSecundariaFora = findTeam(timeDeFora).getCorUniformeSecundario();

		if(corPrimariaCasa.equalsIgnoreCase(corPrimariaFora)){
		    return corSecundariaFora;
        }
		else if (!corPrimariaCasa.equalsIgnoreCase(corPrimariaFora)){
		    return  corPrimariaFora;
        }
		else {
		    throw new TimeNaoEncontradoException();
        }
	}

	private boolean existeEquipe(long id){
		for (CadastroTime team: listarEquipes){
			if (team.getId() == id) return true;
		}
		return false;
	}

	private boolean existeJogador(long idPLayer){
		for (CadastroJogador player: listarJogadores){
			if (player.getId() == idPLayer) return true;
		}
		return false;
	}

	private CadastroJogador findOnePlayer(Long id){
	    return listarJogadores.stream()
                .filter(player -> player.getId()==id)
                .findFirst()
                .get();
    }

	private List<CadastroJogador> findPLayer(Long idTime){
			return listarJogadores.stream()
                    .filter(player -> player.getIdTime()==idTime)
                    .collect(toList());
	}

	private CadastroTime findTeam(Long id) {
        CadastroTime result;
        return result = listarEquipes.stream()
                .filter(t -> t.getId()==id)
                .findFirst()
                .get();
    }
}



