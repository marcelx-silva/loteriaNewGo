package dominio.sorteio;

import dominio.jogo.Jogo;
import dominio.loteria.Loteria;
import dominio.participante.Participante;

import java.util.*;

import static utils.GerarListaNumeros.gerarListaDeNumeros;

public class SorteioImpl implements Sorteio {
    private final List<Integer> numerosSorteados;
    private Set<Participante> vencedores;
    private final Loteria loteria;
    private Integer quantidadeDeJogosPresenteNoSorteio;

    public SorteioImpl(Loteria loteria){
        this.loteria = Objects.requireNonNull(loteria,"Deve haver uma loteria para realizar o sorteio!");
        this.numerosSorteados = new ArrayList<>();
        this.vencedores = new HashSet<>();
        this.numerosSorteados.addAll(sortearNumerosDaLoteria(loteria));
        this.quantidadeDeJogosPresenteNoSorteio = 0;
        setQuantidadeDeJogosPresenteNoSorteio(loteria.getJogos());
    }

    private List<Integer> sortearNumerosDaLoteria(Loteria loteria) {
        List<Integer> numSorteado = gerarListaDeNumeros(loteria.getQuantValoresSeremSorteados());
        System.out.println(numSorteado);
        return numSorteado;
    }

    @Override
    public Set<Participante> getVencedores() {
        return vencedores;
    }

    @Override
    public Integer getQuantidadeJogosPresenteNoSorteio() {
        return quantidadeDeJogosPresenteNoSorteio;
    }

    public void realizarSorteio(){
        Set<Jogo> jogosLoteria = loteria.getJogos();
        for (Jogo jogos:jogosLoteria){
            for (int i = 1;i<=jogos.getJogos().size();i++){
                if (eJogoVencedor(jogos.getJogos().get(i))){
                    vencedores.add(jogos.getParticipante());
                }
            }
        }
        setVencedores(vencedores);
    }

    private boolean eJogoVencedor(List<Integer> jogo){
        return jogo.equals(numerosSorteados);
    }

    private void setQuantidadeDeJogosPresenteNoSorteio(Set<Jogo> jogos){
        for (Jogo jogo:jogos){
            this.quantidadeDeJogosPresenteNoSorteio += jogo.getJogos().size();
        }
    }

    private void setVencedores(Set<Participante> vencedores) {
        this.vencedores = vencedores;
    }
}
