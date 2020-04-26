package challenge;

import java.util.LinkedList;

public class Estacionamento {

    final LinkedList<Carro> vagasDisponiveis = new LinkedList<>();

    private final static Integer IDADE_MINIMA = 18;
    private final static Integer CNH_SUSPENSA = 20;
    private final static Integer MOTORISTA_SENIOR = 56;
    private final static Integer VAGAS_MAX_DISPONIVEIS = 10;

    public void estacionar(Carro carro) {

        checkCarro(carro);

        if(vagasDisponiveis.size() == VAGAS_MAX_DISPONIVEIS){
            for(Carro carroEstacionado: vagasDisponiveis){
                if(carroEstacionado.getMotorista().getIdade() < MOTORISTA_SENIOR){
                    vagasDisponiveis.removeFirstOccurrence(carroEstacionado);
                    break;
                }
            }
        }
        if(vagasDisponiveis.size() == VAGAS_MAX_DISPONIVEIS){
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

    // Método de verificação

    public boolean checkCarro(Carro carro){
        if(carro.getMotorista().getIdade() < IDADE_MINIMA){
            throw new EstacionamentoException("Idade inferior ao mínimo legal");
        }
        else if(carro.getMotorista().getPontos() > CNH_SUSPENSA ){
            throw new EstacionamentoException("Motorista com CNH suspensa.");
        }
        else if(carro.getMotorista().getPontos() < 0){
            throw new EstacionamentoException("Motorista sem pontuação válida");
        }
        return true;
    }
}