package symbols;

public class Spock implements Symbol{
    @Override
    public boolean isBeating(Symbol symbol) {
        return symbol instanceof Rock || symbol instanceof Scissors;

    }
}
