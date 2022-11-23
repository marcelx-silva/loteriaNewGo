package dominio.jogo;

import dominio.loteria.Loteria;
import dominio.participante.Participante;
import enums.TipoLoteria;
import exceptions.InsufficientMoney;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.GerarListaNumeros.gerarListaDeNumeros;

public class Jogo {
    private final Participante participante;
    private final Map<Integer, List<Integer>> jogos;
    private final Loteria loteria;

    public Jogo(Participante participante, Loteria loteria) throws InsufficientMoney {
        this.jogos = new HashMap<>();
        this.participante = participante;
        this.loteria = loteria;
        gerarJogos();
    }

    private void gerarJogos() throws InsufficientMoney {
        Integer quantJogos = calcularQuantJogos
                (this.participante.getValorPago(),this.loteria.getValorJogoLoteria());

        for(Integer i = 1;i<=quantJogos;i++){
            jogos.put(i,gerarListaDeNumeros(loteria.getQuantValoresSeremSorteados()));
        }
    }

    private Integer calcularQuantJogos(Double valorPagoPeloJogador, Double valorJogoLoteria) throws InsufficientMoney {
        verificarQuantiaDinheiroEValida(valorPagoPeloJogador,valorPagoPeloJogador);
        int quantidadeJogos = (int) (valorPagoPeloJogador/valorJogoLoteria);
        participante.setQuantidadeJogoComprados(quantidadeJogos);
        return quantidadeJogos;
    }

    private void verificarQuantiaDinheiroEValida(Double valorPagoPeloJogador, Double valorJogoLoteria) throws InsufficientMoney {
        if (valorPagoPeloJogador<valorJogoLoteria){
            throw new InsufficientMoney("Quantia insuficiente para comprar um jogo!");
        }
    }

    public Map<Integer, List<Integer>> getJogos() {
        return jogos;
    }

    public Participante getParticipante() {
        return participante;
    }

    public TipoLoteria getTipoLoteriaJogo() {
        return loteria.getTipoLoteria();
    }
}
