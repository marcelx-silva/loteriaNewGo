package utils;

import java.security.SecureRandom;

public class GerarNumeros {
    private static final SecureRandom random = new SecureRandom();
    public static Integer gerarNumeros(Integer limite){
        return random.nextInt(limite+1);
    }
}
