package org.example;

import java.util.HashMap;
import java.util.Scanner;


public class Main {

    private Scanner myScanner;

    private void playGame() {
        myScanner = new Scanner(System.in);

        System.out.println("Choose a Game:");
        System.out.println("1. Rock Paper Scissors");
        System.out.println("2. Dog Genetics");
        System.out.println("3. Healthy Hears");
        System.out.println("4. Summative Sums");

        int choice = myScanner.nextInt();
        //int choice = 2;

        Game game;
        game = gameFactory(choice);

        game.play();

    }

    private Game gameFactory(int choice) {
        HashMap<Integer, Game> factory = new HashMap<>();

        factory.put(1, new rockPaperScissors());
        factory.put(2, new dogGenetics());
        factory.put(3, new healthyHearts());
        factory.put(4, new summativeSums());

        return factory.get(choice);
    }


    public static void main(String[] args) {
        Main myGame = new Main();
        myGame.playGame();

    }
}







