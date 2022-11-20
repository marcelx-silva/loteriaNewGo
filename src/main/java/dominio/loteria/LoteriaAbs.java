package dominio.loteria;

import dominio.jogo.Jogo;
import enums.TipoLoteria;

import java.util.Set;

public abstract class LoteriaAbs implements Loteria {
    protected String nome;
    protected TipoLoteria tipo;
    protected Set<Jogo> jogos;
    protected Integer valorDecimalMaximo;
    protected Integer quantValoresSeremSorteados;
    protected Double valorJogo;
    protected Integer quantidadeJogosPresenteNaLoteria;

    LoteriaAbs(){
        this.quantidadeJogosPresenteNaLoteria = 0;
    }

    @Override
    public Integer getValorDecimalMaximo() {
        return valorDecimalMaximo;
    }

    @Override
    public Integer getQuantValoresSeremSorteados(){return quantValoresSeremSorteados;}

    @Override
    public TipoLoteria getTipoLoteria() {
        return tipo;
    }

    @Override
    public Double getValorJogoLoteria(){
        return valorJogo;
    }

    @Override
    public Set<Jogo> getJogos() {
        return jogos;
    }

    public String getNome() {
        return nome;
    }
}
