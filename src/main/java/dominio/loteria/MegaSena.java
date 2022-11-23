package dominio.loteria;

import dominio.jogo.Jogo;
import enums.TipoLoteria;
import exceptions.IncompatibleGameType;

import java.util.HashSet;

public class MegaSena extends LoteriaAbs{
    private final Integer QUANTIDADE_MAXIMA_VALORES_A_SEREM_SORTEADOS = 3;
    private final Integer VALOR_DECIMAL_MAXIMO = 20;
    private final Double VALOR_JOGO_LOTERIA = 6.00;

    public MegaSena() {
        this.jogos = new HashSet<>();
        setValorJogoLoteria();
        setTipoLoteria();
        setValorDecimalMaximo();
        setQuantValoresSeremSorteados();
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

    private void setTipoLoteria() {
        this.tipo = TipoLoteria.MEGASENA;
    }
    private void setValorDecimalMaximo(){
        this.valorDecimalMaximo = VALOR_DECIMAL_MAXIMO;
    }
    private void setQuantValoresSeremSorteados(){
        this.quantValoresSeremSorteados = QUANTIDADE_MAXIMA_VALORES_A_SEREM_SORTEADOS;
    }
    private void setValorJogoLoteria() {
        this.valorJogo = VALOR_JOGO_LOTERIA;
    }


}
