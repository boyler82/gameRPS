package domain;

import symbols.Symbol;

import java.util.Objects;

public abstract class Player {
    private int id;
    private String name;
    private Symbol symbol;
    private int points;

    public Player(String name) {
        this.name = name;
        this.points = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return getId() == player.getId() && getPoints() == player.getPoints() && Objects.equals(getSymbol(), player.getSymbol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSymbol(), getPoints());
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", symbol=" + symbol +
                ", points=" + points +
                '}';
    }

    public void addPoint() {
        setPoints(getPoints() + 1);
    }
}
