package dominio.participante;

import java.util.UUID;

public class Participante {
    private UUID uuid;
    private String nome;
    private double valorPago;
    private Integer quantJogoComprado;

    public Participante(String nome, double valorPago){
        this.uuid = UUID.randomUUID();
        this.nome = nome;
        setValorPago(valorPago);
    }

    private void setValorPago(double valorPago){
        if (valorPago<=0)
            this.valorPago = 0;
        else
            this.valorPago = valorPago;
    }

    public String getNome() {
        return nome;
    }

    public double getValorPago() {
        return valorPago;
    }

    public Integer getQuantJogos() {
        return quantJogoComprado;
    }

    public UUID getUUID() {
        return uuid;
    }

    public void setQuantidadeJogoComprados(int quantidadeJogos) {
        this.quantJogoComprado = quantidadeJogos;
    }
}
