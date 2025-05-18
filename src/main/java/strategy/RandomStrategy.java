package strategy;

import symbols.Symbol;

import java.util.List;
import java.util.Random;

public class RandomStrategy implements CpuStrategy{
    private Random random =new Random();

    @Override
    public Symbol chooseSymbol(List<Symbol> availableSymbols) {
        return availableSymbols.get(random.nextInt(availableSymbols.size()));
    }
}
