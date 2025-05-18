package symbols;

public class Rock implements Symbol {
    @Override
    public boolean isBeating(Symbol symbol) {

        return symbol instanceof Scissors || symbol instanceof Lizard;
    }
}
