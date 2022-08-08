package org.example;

import java.util.HashMap;

public class rockPaperScissors extends Game {


    private HashMap<Integer, String> choiceMap = new HashMap<>();

    private int playerWins;
    private int compWins;
    private int draws;

    public void play() {

        choiceMap.put(1, "Rock");
        choiceMap.put(2, "Paper");
        choiceMap.put(3, "Scissors");

        int choice;
        do {
            playerWins = 0;
            compWins = 0;
            draws = 0;
            playRPS();
            System.out.println("Again? y/n -> 1/0 :: ");
            choice = myScanner.nextInt();
        } while (choice == 1);

    }


    private void playRPS() {

        System.out.println("Rock Paper Scissors.");

        int numRounds = enterNumRounds();

        for (int i=0; i<numRounds; i++){
            System.out.println("\n\nRound " + i);
            playRound();
        }

        System.out.println("\n\nPlayer - Computer");
        System.out.printf("     %s - %s\n",playerWins, compWins);


        if (playerWins == compWins) {
            System.out.println("Draw!");
        } else if (playerWins > compWins) {
            System.out.println("Player wins!");
        } else if (compWins > playerWins) {
            System.out.println("Comp wins!");
        }

        System.out.println("\n\n");
    }

    private void playRound() {
        //1rock, 2paper, 3scissors
        int playerChoice = enterChoice();
        int compChoice;
        compChoice = (int) Math.floor(3*Math.random()) + 1;

        calculateRound(playerChoice, compChoice);




    }

    private void calculateRound(int pChoice, int cChoice){
        short winner = 0;//-1=draw, 0=player, 1=comp
        String pChoiceText = choiceMap.get(pChoice);
        String cChoiceText = choiceMap.get(cChoice);

        if (pChoice == cChoice){
            draws++;winner=-1;
        } else if (pChoice == 1) {
            if (cChoice == 2) {compWins++;winner=1;}
            else if (cChoice == 3) {playerWins++;winner=0;}
        } else if (pChoice == 2) {
            if (cChoice == 1) {playerWins++;winner=0;}
            else if (cChoice == 3) {compWins++;winner=1;}
        } else if (pChoice == 3) {
            if (cChoice == 1) {compWins++;winner=1;}
            else if (cChoice == 2) {playerWins++;winner=0;}
        }

        if (winner == -1) {
            System.out.println("Draw!");
        } else if (winner == 0) {
            System.out.printf("%s beats %s. Player wins!\n", pChoiceText, cChoiceText);
        } else if (winner == 1) {
            System.out.printf("%s beats %s. Comp wins!\n", cChoiceText, pChoiceText);
        }

    }

    private int enterChoice() {
        int playerEntry;
        System.out.print("1 Rock, 2 Paper, 3 Scissors. Enter :: ");
        playerEntry = myScanner.nextInt();

        return playerEntry;
    }

    private int enterNumRounds() {
        int numRounds;

        do {
            System.out.print("How many rounds :: ");
            numRounds = myScanner.nextInt();
        } while (numRounds < 1 || numRounds > 10);

        return numRounds;

    }


}