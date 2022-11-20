package dominio.loteria;

import dominio.jogo.Jogo;
import enums.TipoLoteria;
import exceptions.IncompatibleGameType;

import java.util.Set;

public interface Loteria {
    void adicionarJogos(Jogo jogos) throws IncompatibleGameType;
    TipoLoteria getTipoLoteria();
    Integer getQuantValoresSeremSorteados();
    Integer getValorDecimalMaximo();
    Double getValorJogoLoteria();
    Set<Jogo> getJogos();

}
