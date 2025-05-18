package factory;

import builder.GameBuilder;
import domain.CpuPlayer;
import domain.Game;
import domain.Player;
import symbols.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameFactory {
    public static Game createFromInput() {
        Scanner scanner = new Scanner(System.in);
        String name = "";

        while (name.length() < 3) {
            System.out.print("Podaj swoje imię: ");
            name = scanner.nextLine();
            if (name.length() < 3) {
                System.out.println("Imię za krótkie.");
            }
        }

        List<Symbol> selectedSymbols = List.of();
        System.out.println("Wybierz tryb gry:");
        System.out.println("1 - Normal (Rock, Paper, Scissors)");
        System.out.println("2 - Extended (+ Lizard, Spock)");


        int mode = -1;
        while( mode>2 || mode<1) {
            if (scanner.hasNextInt()) {
                mode = scanner.nextInt();
                scanner.nextLine();
                if (mode == 2) {
                    selectedSymbols = List.of(new Rock(), new Paper(), new Scissors(), new Lizard(), new Spock());
                } else {
                    selectedSymbols = List.of(new Rock(), new Paper(), new Scissors());
                }
            } else {
                System.out.println("Wybierz 1 lub 2.");
            }
        }

        int rounds = 0;
        while (rounds <= 0) {
            System.out.print("Podaj liczbę rund: ");
            if (scanner.hasNextInt()) {
                rounds = scanner.nextInt();
                scanner.nextLine(); // wyczyść bufor
                if (rounds <= 0) {
                    System.out.println("Liczba musi być większa od 0.");
                }
            } else {
                System.out.println("To nie jest liczba.");
                scanner.nextLine();
            }
        }

        return new GameBuilder()
                .withUserName(name)
                .withRounds(rounds)
                .withSymbols(selectedSymbols)
                .build();
    }

    public static Game demoPlayHundred() {
        return new GameBuilder()
                .withRounds(100)
                .withCpuName1("CPU-1")
                .withCpuName2("CPU-2")
                .withSymbols(List.of(new Rock(), new Paper(), new Scissors(), new Lizard(), new Spock()))
                .withCpuPlayers()
                .build();
    }
}
