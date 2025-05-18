package symbols;

public class Lizard implements Symbol{
    @Override
    public boolean isBeating(Symbol symbol) {
        return symbol instanceof Spock || symbol instanceof Paper;

    }
}
