package br.com.codenation;

import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;

import static java.util.stream.Collectors.toList;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	private CadastroTime equipe;
	private CadastroJogador jogador;

	private List<CadastroTime> listarEquipes = new ArrayList<>();
	private List<CadastroJogador>listarJogadores = new ArrayList<>();


	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario){
		validadorEquipe(id, nome, dataCriacao,corUniformePrincipal,corUniformeSecundario);
	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario){
		validadorJogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
	}


	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {

		if(!existeJogador(idJogador)) {
			throw new JogadorNaoEncontradoException();
		}

		CadastroTime equipe = findTeambyId(jogador.getIdTime());

		if(equipe == null){
			throw new TimeNaoEncontradoException();
		}

		equipe.setCapitao(jogador);
	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {

		CadastroTime equipe = findTeambyId(idTime);

		if(equipe == null){
			throw new TimeNaoEncontradoException();
		}

		CadastroJogador capitaoDoTime = equipe.getCapitao();

		if(equipe.getCapitao() == null){
			throw new CapitaoNaoInformadoException();
		}

		return equipe.getCapitao().getId();
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {
		CadastroJogador jogador = findOnePlayer(idJogador);

		if (jogador == null){
			throw new JogadorNaoEncontradoException();
		}
		if (idJogador == null){
			throw new NullPointerException();
		}
		return jogador.getNome();
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {
		CadastroTime equipe = findTeambyId(idTime);

		if(equipe == null){
			throw new TimeNaoEncontradoException();
		}
		if(idTime == null){
			throw new NullPointerException();
		}

		return equipe.getNome();

	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {
		CadastroTime equipe = findTeambyId(idTime);

		if(equipe == null){
		    throw new NullPointerException();
        }
		if(idTime == null){
		    throw new NullPointerException();
        }

		List<CadastroJogador> players = findPLayer(idTime);

		return players.stream()
                .sorted(Comparator.comparing(CadastroJogador::getId))
                .map(CadastroJogador::getId)
                .collect(Collectors.toList());
	}

    @Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {

	    CadastroTime equipe = findTeambyId(idTime);

	    if(equipe == null){
	        throw new TimeNaoEncontradoException();
        }
	    if(idTime  == null){
	        throw new NullPointerException();
        }

	    List<CadastroJogador> listPlayers = findPLayer(idTime);

	    CadastroJogador bestPlayer = Collections.max(listPlayers, Comparator.comparingInt(CadastroJogador::getNivelHabilidade));

	    return bestPlayer.getId();
	}

    // PAREI AQUI
    @Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {
		List<CadastroJogador> jogadores;
		Long olderPlayer;

		if(!existeEquipe(idTime)) {
			throw new TimeNaoEncontradoException();
		}
		else{
			jogadores = findPLayer(idTime);
			olderPlayer = jogadores.stream().max(Comparator.comparingLong(CadastroJogador::getIdade)).get().getId();
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
        List<CadastroJogador> jogadores;
        Long salario;

        if(!existeEquipe(idTime)) {
        	throw new TimeNaoEncontradoException();
		}
        else{
        	jogadores = findPLayer(idTime);
        	salario = jogadores.stream().max(Comparator.comparing(CadastroJogador::getSalario)).get().getId();
		}
        return salario;
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
			topPlayers = listarJogadores.stream().sorted(Comparator.comparingInt(CadastroJogador::getNivelHabilidade)).collect(toList());
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

	public CadastroTime existeEquipe(long id){
		return listarEquipes.stream()
				.filter(time -> CadastroTime
						.getId()
						.equals(id)
						.findAny()
						.orElse(null);
	}

	public CadastroTime validadorEquipe(Long id,
										String nome,
										LocalDate dataCriacao,
										String corUniformePrincipal,
										String corUniformeSecundario){

		if(id == null){
			throw new NullPointerException();
		}
		if(nome == null){
			throw new NullPointerException();
		}
		if(dataCriacao == null){
			throw new NullPointerException();
		}
		if(corUniformePrincipal == null){
			throw new NullPointerException();
		}
		if(corUniformeSecundario == null){
			throw new NullPointerException();
		}
		if(existeEquipe(id) != null){
			throw new IdentificadorUtilizadoException();
		}

		listarEquipes.add(new CadastroTime(
				id,
				nome,
				dataCriacao,
				corUniformePrincipal,
				corUniformeSecundario));

		return equipe;
	}

	public CadastroJogador validadorJogador(Long id,
								   Long idTime,
								   String nome,
								   LocalDate dataNascimento,
								   Integer nivelHabilidade,
								   BigDecimal salario){

		if(id == null){
			throw new NullPointerException();
		}
		if(idTime == null){
			throw new NullPointerException();
		}
		if(nome == null && nome.trim().isEmpty()){
			throw new NullPointerException();
		}
		if(dataNascimento == null){
			throw new NullPointerException();
		}
		if(nivelHabilidade == null){
			throw new NullPointerException();
		}
		if(salario == null){
			throw new NullPointerException();
		}
		if(findOnePlayer(id) != null){
			throw new NullPointerException();
		}
		if(findTeam(idTime) == null){
			throw new NullPointerException();
		}
		if(nivelHabilidade < 0 || nivelHabilidade > 100){
			throw new InvalidParameterException();
		}

		listarJogadores.add(new CadastroJogador(
				id,
				idTime,
				nome,
				dataNascimento,
				nivelHabilidade,
				salario));

		return jogador;

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

	private CadastroTime findTeambyId(Long id) {
        CadastroTime result;
        return result = listarEquipes.stream()
                .filter(t -> t.getId()==id)
                .findFirst()
                .get();
    }
}



