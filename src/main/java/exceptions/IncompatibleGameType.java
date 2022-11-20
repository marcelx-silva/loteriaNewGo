package exceptions;

public class IncompatibleGameType extends Exception {
    public IncompatibleGameType(){
        super("Tipo de jogo incompátivel com a Loteria");
    }
}
