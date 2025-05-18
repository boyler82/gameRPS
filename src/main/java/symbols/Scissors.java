package symbols;

public class Scissors implements Symbol {
    @Override
    public boolean isBeating(Symbol symbol) {

        return symbol instanceof Paper || symbol instanceof Lizard;
    }
}
