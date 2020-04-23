package challenge;

import java.util.LinkedList;

public class Estacionamento {

    final LinkedList<Carro> vagasDisponiveis = new LinkedList<>();

    public void estacionar(Carro carro) {

        if(carro.getMotorista().getIdade() < 18){
            throw new EstacionamentoException("Idade inferior ao mínimo legal");
        }
        else if(carro.getMotorista().getPontos() > 20 ){
            throw new EstacionamentoException("Motorista com CNH suspensa.");
        }
        else if(carro.getMotorista().getPontos() < 0){
            throw new EstacionamentoException("Motorista sem pontuação válida");
        }

        if(vagasDisponiveis.size() == 10){
            for(Carro carroEstacionado: vagasDisponiveis){
                if(carroEstacionado.getMotorista().getIdade() < 56){
                    vagasDisponiveis.removeFirstOccurrence(carroEstacionado);
                    break;
                }
            }
        }
        if(vagasDisponiveis.size() == 10){
            throw new EstacionamentoException("Todas as vagas prioritárias preenchidas.");
        }
        vagasDisponiveis.add(carro);
    }

    public int carrosEstacionados() {
        return vagasDisponiveis.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return vagasDisponiveis.contains(carro);
    }
}