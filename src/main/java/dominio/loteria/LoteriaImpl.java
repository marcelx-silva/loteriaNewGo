package dominio.loteria;

import dominio.jogo.Jogo;
import enums.TipoLoteria;
import exceptions.IncompatibleGameType;

import java.util.HashSet;

public class LoteriaImpl extends LoteriaAbs {
    public LoteriaImpl(String nome, Integer valorDecimalMaximo, Integer quantValoresSeremSorteados, Double valorJogo, TipoLoteria tipo){
        super();
        this.tipo = tipo;
        this.valorDecimalMaximo = valorDecimalMaximo;
        this.quantValoresSeremSorteados = quantValoresSeremSorteados;
        this.valorJogo = valorJogo;
        this.jogos = new HashSet<>();
    }

    @Override
    public void adicionarJogos(Jogo jogos) throws IncompatibleGameType {
        if (jogos.getTipoLoteriaJogo() != getTipoLoteria()){
            throw new IncompatibleGameType();
        }
        if (this.jogos.contains(jogos)){
            System.out.println("Jogo já presente no Sorteio!");
        }
        this.jogos.add(jogos);
    }


}
