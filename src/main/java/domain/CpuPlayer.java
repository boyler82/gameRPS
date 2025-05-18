package domain;

import strategy.CpuStrategy;
import strategy.RandomStrategy;
import symbols.Symbol;

import java.util.List;

public class CpuPlayer extends Player {
    private CpuStrategy strategy;

    public CpuPlayer() {
        super("CPU");
    }

    public CpuPlayer(String name) {
        this(name, new RandomStrategy());
    }

    public CpuPlayer(String name, CpuStrategy strategy) {
        super(name);
        this.strategy = strategy;
    }

    public CpuStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(CpuStrategy strategy) {
        this.strategy = strategy;
    }

    public Symbol chooseSymbol(List<Symbol> options) {
        return strategy.chooseSymbol(options);
    }

//    o co tu chodzi ?
}
