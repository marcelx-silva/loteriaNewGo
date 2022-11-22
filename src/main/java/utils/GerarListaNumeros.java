package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static utils.GerarNumeros.gerarNumeros;

public class GerarListaNumeros {
    public static List<Integer> gerarListaDeNumeros(Integer limite){
        List<Integer> numerosDoJogo = new ArrayList<>();
        while (numerosDoJogo.size() < limite){
            Integer num = gerarNumeros(limite);
            adicionarElementoNaoRepetidos(numerosDoJogo,num);
        }
        Collections.sort(numerosDoJogo);
        return numerosDoJogo;
    }

    private static void adicionarElementoNaoRepetidos(List<Integer> numerosDoJogo, Integer num){
        if (!numerosDoJogo.contains(num)){
            numerosDoJogo.add(num);
        }
    }
}
