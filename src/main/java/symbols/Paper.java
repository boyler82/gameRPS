package symbols;

public class Paper implements Symbol {
    @Override
    public boolean isBeating(Symbol symbol) {

        return symbol instanceof Rock || symbol instanceof Spock;
    }
}
