package builder;

import domain.Game;
import domain.User;
import domain.CpuPlayer;
import domain.Player;
import symbols.Symbol;

import java.util.List;

public class GameBuilder {
    private int rounds = 3; // domyślna liczba rund
    private String userName = "Gracz";
    private String cpuName1 = "CPU-1";
    private String cpuName2 = "CPU-2";
    private boolean cpuVsCpu = false;
    private List<Symbol> symbols;


    public GameBuilder withRounds(int rounds) {
        this.rounds = rounds;
        return this;
    }

    public GameBuilder withUserName(String name) {
        this.userName = name;
        return this;
    }

    public GameBuilder withCpuName1(String name) {
        this.cpuName1 = name;
        return this;
    }

    public GameBuilder withCpuName2(String name) {
        this.cpuName2 = name;
        return this;
    }

    public GameBuilder withCpuPlayers() {
        this.cpuVsCpu = true;
        return this;
    }

    public GameBuilder withSymbols(List<Symbol> symbols) {
        this.symbols = symbols;
        return this;
    }

    public Game build() {
        Game game;
        if (cpuVsCpu) {
            game =  new Game(new CpuPlayer(cpuName1), new CpuPlayer(cpuName2), rounds);
        } else {
            game = new Game(new CpuPlayer(cpuName1), new User(userName), rounds);
        }
        game.setSymbols(symbols);
        return game;
    }


}