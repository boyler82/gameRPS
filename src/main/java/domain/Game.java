package domain;

import strategy.RandomStrategy;
import symbols.Symbol;

import java.awt.print.Paper;
import java.util.*;

public class Game {
    private Player player1;
    private Player player2;
    private int rounds;
    private List<Symbol> symbols;

    public Game(String userName, int rounds) {
        this.player1 = new CpuPlayer("CPU",new RandomStrategy());
        this.player2 = new User(userName);
        this.rounds = rounds;
    }

    public Game(Player player1, Player player2, int rounds) {
        this.player1 = player1;
        this.player2 = player2;
        this.rounds = rounds;
    }

    public Game() {
    }

    public List<Symbol> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<Symbol> symbols) {
        this.symbols = symbols;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        if (player1 == null) throw new IllegalArgumentException("Can't set player as null");
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        if (player2 == null) throw new IllegalArgumentException("Can't set player as null");
        this.player2 = player2;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return getRounds() == game.getRounds() && Objects.equals(getPlayer1(), game.getPlayer1()) && Objects.equals(getPlayer2(), game.getPlayer2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlayer1(), getPlayer2(), getRounds());
    }

}
