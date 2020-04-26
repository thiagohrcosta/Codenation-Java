package test;

import br.com.codenation.Time;
import br.com.codenation.Jogador;
import br.com.codenation.DesafioMeuTimeApplication;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.assertEquals;

public class DesafioMeuTimeApplicationTest {
    private final LocalDate NOW = LocalDate.from(LocalDateTime.now());
    List<Time> listarTimes = new ArrayList<>();
    List<Jogador> listarJogadores = new ArrayList<>();

    @Test
    public void deveriaCadastrarTime(){

        Time newTime1 = new Time(1L, "AC MILAN", NOW, "Vermelhor", "Branco" );
        //Time newTime2 = new Time(2L, "AC MILAN", NOW, "Vermelhor", "Branco" );

        listarTimes.add(newTime1);

        assertEquals(newTime1.getNome(), "AC MILAN");
    }

    @Test
    public void deveriaCadastrarJogadores(){
        Jogador newJogador1 = new Jogador(
                1L,
                1L,
                "Filippo Inzaghi",
                NOW,
                90,
                new BigDecimal(200000));

        listarJogadores.add(newJogador1);

        assertEquals(newJogador1.getNome(), "Filippo Inzaghi");
    }



}