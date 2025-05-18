package strategy;

import symbols.Symbol;

import java.util.List;

public interface CpuStrategy {
    Symbol chooseSymbol(List<Symbol> availableSymbols);
}

