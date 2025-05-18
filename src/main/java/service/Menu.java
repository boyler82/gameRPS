package service;

import factory.GameFactory;

import java.util.Scanner;

public class Menu {

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("======= MENU =======");
            System.out.println("1 - Nowa gra");
            System.out.println("2 - Demo");
            System.out.println("3 - Restart");
            System.out.println("4 - Wyjście");
            System.out.print("Wybierz opcję: ");
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    GamePlay gamePlay = new GamePlay();
                    gamePlay.play();
                    break;
                case "2":
                    GamePlay demo = new GamePlay();
                    demo.autoPlay(GameFactory.demoPlayHundred());
                    break;
                case "3":
                    System.out.println("Restart gry... (jeszcze niezaimplementowane)");
                    break;
                case "4":
                    System.out.println("Do zobaczenia!");
                    return;
                default:
                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }
    }
}
