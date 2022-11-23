package ui;

import dominio.participante.Participante;
import dominio.premio.Premio;
import dominio.sorteio.Sorteio;

public class ExibirConcurso implements ExibicaoUI {

    private final Sorteio sorteio;
    private final Premio premio;

    public ExibirConcurso(Sorteio sorteio, Premio premio) {
        this.sorteio = sorteio;
        this.premio = premio;
    }

    @Override
    public void exibirPremiacaoLoteria(){
        System.out.println("Premiação");
        System.out.println("-----------------");
        System.out.println("Vencedores:");
        if (sorteio.getVencedores().size()!=0){
            sorteio.getVencedores().forEach(sorteio->{
                System.out.println("- "+sorteio.getNome());
            });
        }else{
            System.out.println("Nenhum");
        }
        System.out.println("Valor total da Premiação: "+premio.getPremioTotal()+
                "\nValor Distribuido para cada Vencedor: "+premio.distribuirPremio());
    }

    @Override
    public void exibirResultadoLoteria(){
        if (sorteio.getVencedores().isEmpty()){
            System.out.println("Não há um vencedor do atual concurso!");
            return;
        }
        for (Participante vencedor:sorteio.getVencedores()){
            System.out.println("Identificador:"+ vencedor.getUUID()+"\nNome:"+vencedor.getNome()+"" +
                    "\nQuantidade de Jogos: "+ vencedor.getQuantJogos());
            System.out.println("-------------------------------");
        }
        System.out.println();

    }
}
