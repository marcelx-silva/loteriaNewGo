package dominio.premio;

import dominio.loteria.Loteria;
import dominio.sorteio.Sorteio;

public class PremioImpl implements Premio {

    private final Sorteio sorteio;
    private final Loteria loteria;
    private Double premioTotal;

    public PremioImpl(Sorteio sorteio, Loteria loteria){
        this.sorteio = sorteio;
        this.loteria = loteria;
        calcularPremio();
    }

    @Override
    public void calcularPremio(){
        setPremioTotal(sorteio.getQuantidadeJogosPresenteNoSorteio()*loteria.getValorJogoLoteria());
    }

    @Override
    public Double distribuirPremio(){
        if (sorteio.getVencedores().size()!=0){
            return  premioTotal/sorteio.getVencedores().size();
        }
        return 0.0;
    }

    private void setPremioTotal(Double premioTotal) {
        this.premioTotal = premioTotal;
    }

    @Override
    public Double getPremioTotal(){
        return premioTotal;
    }

}