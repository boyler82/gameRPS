package service;

import domain.*;
import factory.GameFactory;
import strategy.AlwaysRockStrategy;
import strategy.RandomStrategy;
import symbols.Paper;
import symbols.Rock;
import symbols.Scissors;
import symbols.Symbol;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GamePlay {

    public void play() {
        Game game = GameFactory.createFromInput();
        for (int round = 1; round <= game.getRounds(); round++) {
            System.out.println("Runda " + round);

            List<Symbol> symbols = game.getSymbols();
            Random random = new Random();
            int cpuChoice = random.nextInt(symbols.size());
            game.getPlayer1().setSymbol(symbols.get(cpuChoice));

            Scanner scanner = new Scanner(System.in);
            int userChoice = -1;
            while (userChoice < 1 || userChoice > symbols.size()) {
                System.out.println("Wybierz symbol:");
                for (int i =1; i<=symbols.size(); i++) {
                    System.out.println(i + " - " + symbols.get(i-1).getClass().getSimpleName());
                }

                if (scanner.hasNextInt()) {
                    userChoice = scanner.nextInt();
                    if (userChoice >= 1 && userChoice <= symbols.size()) {
                        game.getPlayer2().setSymbol(symbols.get(userChoice - 1));
                    } else {
                        System.out.println("Niepoprawny wybór.");
                    }
                } else {
                    System.out.println("To nie jest liczba.");
                    scanner.next();
                }
            }

            Symbol cpuSymbol = game.getPlayer1().getSymbol();
            Symbol userSymbol = game.getPlayer2().getSymbol();
            System.out.println();
            for (int i=0; i < round; i++) {
                System.out.print("*");
            }
            System.out.print(" Runda " + round + " ");
            for (int i=0; i < round; i++) {
                System.out.print("*");
            }
            System.out.println();
            System.out.println("CPU wybrał: " + cpuSymbol.getClass().getSimpleName());
            System.out.println("Ty wybrałeś: " + userSymbol.getClass().getSimpleName());

            if (cpuSymbol.isBeating(userSymbol)) {
                game.getPlayer1().setPoints(game.getPlayer1().getPoints() + 1);
                System.out.println("CPU wygrywa rundę.");
            } else if (userSymbol.isBeating(cpuSymbol)) {
                game.getPlayer2().setPoints(game.getPlayer2().getPoints() + 1);
                System.out.println(game.getPlayer2().getName() + " wygrywa rundę!");
            } else {
                System.out.println("Remis!");
            }

            System.out.println("Wynik: CPU " + game.getPlayer1().getPoints() +
                    " - " + game.getPlayer2().getPoints() + " TY");
            System.out.println("------------");
        }

        System.out.println("Koniec gry!");
        Player winner = getWinner(game);
        if (winner.equals(game.getPlayer1())) {
            System.out.println("Zwycięzca gracz komputerowy");
        } else {
            System.out.println(game.getPlayer2().getName().toUpperCase() + " wygrywa, CPU pokonany");
        }
    }

    private Player getWinner(Game game) {
        if (game.getPlayer1().getPoints() > game.getPlayer2().getPoints()) {
            return game.getPlayer1();
        } else if (game.getPlayer1().getPoints() < game.getPlayer2().getPoints()) {
            return game.getPlayer2();
        } else {
            return new User("Remis");
        }
    }

    public void autoPlay(Game game) {
        System.out.println("=== TRYB DEMO: CPU vs CPU ===");
//        List<Symbol> symbols = List.of(new Rock(), new Paper(), new Scissors());

        CpuPlayer cpu1 = (CpuPlayer) game.getPlayer1();
        CpuPlayer cpu2 = (CpuPlayer) game.getPlayer2();

        cpu1.setStrategy(new RandomStrategy());
        cpu2.setStrategy(new AlwaysRockStrategy());

        for (int i = 1; i <= game.getRounds(); i++) {
            Symbol move1 = cpu1.chooseSymbol(game.getSymbols());
            Symbol move2 = cpu2.chooseSymbol(game.getSymbols());

            cpu1.setSymbol(move1);
            cpu2.setSymbol(move2);

            System.out.println("Runda " + i + ": "
                    + game.getPlayer1().getName() + " [" + move1.getClass().getSimpleName() + "] vs "
                    + game.getPlayer2().getName() + " [" + move2.getClass().getSimpleName() + "]");

            if (move1.isBeating(move2)) {
                game.getPlayer1().addPoint();
            } else if (move2.isBeating(move1)) {
                game.getPlayer2().addPoint();
            } // remis – bez punktów

        }

        System.out.println("=== KONIEC GRY ===");
        System.out.println(game.getPlayer1().getName() + ": " + game.getPlayer1().getPoints() + " pkt");
        System.out.println(game.getPlayer2().getName() + ": " + game.getPlayer2().getPoints() + " pkt");

        if (game.getPlayer1().getPoints() > game.getPlayer2().getPoints()) {
            System.out.println("Zwycięzca: " + game.getPlayer1().getName());
        } else if (game.getPlayer2().getPoints() > game.getPlayer1().getPoints()) {
            System.out.println("Zwycięzca: " + game.getPlayer2().getName());
        } else {
            System.out.println("Remis!");
        }
    }
}
