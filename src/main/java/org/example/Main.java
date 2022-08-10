package org.example;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;
import static java.util.Map.entry;


public class Main {

    private static final Map<Integer, Supplier<Game>> gameFactoryMap = Map.ofEntries(
            entry(1, RockPaperScissors::new),
            entry(2, DogGenetics::new),
            entry(3, HealthyHearts::new),
            entry(4, SummativeSums::new)
    );

    private Scanner myScanner = new Scanner(System.in);

    private void playGame() {

        System.out.println("""
                Choose a game:
                1. Rock Paper Scissors
                2. Dog Genetics
                3. Healthy Hearts
                4. Summative Sums
                """);

        System.out.print("Choice :: ");
        int choice = myScanner.nextInt();


        Game game;
        game = createGame(choice);

        if (game == null){
            System.out.println("Invalid choice.");
            return;
        }

        game.play();

    }

    private static Game createGame(int choice) {
        Supplier<Game> factory = gameFactoryMap.get(choice);
        return factory == null ? null : factory.get();
    }


    public static void main(String[] args) {
        Main myGame = new Main();
        myGame.playGame();

    }
}







