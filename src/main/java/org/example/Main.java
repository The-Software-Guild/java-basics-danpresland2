package org.example;

import java.util.HashMap;
import java.util.Scanner;


public class Main {

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
        game = gameFactory(choice);

        if (game == null){
            System.out.println("Invalid choice.");
            return;
        }

        game.play();

    }

    private Game gameFactory(int choice) {
        HashMap<Integer, Game> factory = new HashMap<>();

        factory.put(1, new RockPaperScissors());
        factory.put(2, new DogGenetics());
        factory.put(3, new HealthyHearts());
        factory.put(4, new SummativeSums());

        return factory.get(choice);
    }


    public static void main(String[] args) {
        Main myGame = new Main();
        myGame.playGame();

    }
}







