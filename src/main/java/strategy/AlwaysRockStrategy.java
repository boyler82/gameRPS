package strategy;

import symbols.Symbol;
import symbols.Rock;
import java.util.List;


public class AlwaysRockStrategy implements CpuStrategy {
    @Override
    public Symbol chooseSymbol(List<Symbol> availableSymbols) {
        return new Rock(); // ignoruje dostępne symbole, zawsze Rock
    }
}
