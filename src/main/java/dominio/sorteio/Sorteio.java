package dominio.sorteio;

import dominio.participante.Participante;

import java.util.Set;

public interface Sorteio {
    void realizarSorteio();
    Set<Participante> getVencedores();
    Integer getQuantidadeJogosPresenteNoSorteio();
}
