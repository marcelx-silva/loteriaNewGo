package dominio;

import dominio.jogo.Jogo;
import dominio.loteria.Loteria;
import dominio.loteria.MegaSena;
import dominio.participante.Participante;
import dominio.premio.Premio;
import dominio.premio.PremioImpl;
import dominio.sorteio.Sorteio;
import dominio.sorteio.SorteioImpl;
import exceptions.IncompatibleGameType;
import exceptions.InsufficientMoney;
import ui.ExibicaoUI;
import ui.ExibirConcurso;

public class Main {
    public static void main(String[] args) throws InsufficientMoney, IncompatibleGameType {
        //Criacao Jogadores
        Participante participante1 = new Participante("Lúcia",160000.0);
        Participante participante2 = new Participante("Caio",160000.0);

        //Criacao da Loteria
        Loteria megaSena = new MegaSena();

        //Criacao do Gerador de Numeros

        //Criacao Jogos
        Jogo jogoLucia = new Jogo(participante1,megaSena);
        Jogo jogoCaio = new Jogo(participante2,megaSena);

        //Adicionar Jogos
        megaSena.adicionarJogos(jogoLucia);
        megaSena.adicionarJogos(jogoCaio);

        //Criacao do Sorteio
        Sorteio sorteio = new SorteioImpl(megaSena);

        //Realizacao do Sorteio
        sorteio.realizarSorteio();

        //Criacao da Premiacao
        Premio premio = new PremioImpl(sorteio,megaSena);

        // Visualizar o Resultado da Loteria
        ExibicaoUI exibirConcurso = new ExibirConcurso(sorteio,premio);
        exibirConcurso.exibirResultadoLoteria();
        exibirConcurso.exibirPremiacaoLoteria();
    }
}
