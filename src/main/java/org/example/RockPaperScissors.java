package org.example;

import java.util.HashMap;

public class RockPaperScissors implements Game {


    private static HashMap<Integer, String> choiceMap = new HashMap<>();//convert 1,2,3 to rock, paper, scissors
    static {
        choiceMap.put(1, "Rock");
        choiceMap.put(2, "Paper");
        choiceMap.put(3, "Scissors");
    }

    private int playerWins;
    private int compWins;
    private int draws;


    /**
     *
     */
    @Override
    public void play() {

        int choice;
        do {
            playerWins = 0;
            compWins = 0;
            draws = 0;

            playRPS();

            System.out.print("Again? 1/0 :: ");
            choice = myScanner.nextInt();
            System.out.println();

        } while (choice == 1);

    }


    /**
     *
     */
    private void playRPS() {
        System.out.println("*******************");
        System.out.println("Rock Paper Scissors");

        int numRounds = enterNumRounds();

        for (int i=0; i<numRounds; i++){
            System.out.println("\n\nRound " + (i+1));
            playRound();
        }

        System.out.println("\n\nPlayer - Computer");
        System.out.printf("     %s - %s\n",playerWins, compWins);

        if (playerWins == compWins) {
            System.out.println("Draw!");
        } else if (playerWins > compWins) {
            System.out.println("Player wins!");
        } else { // compWins > playerWins
            System.out.println("Comp wins!");
        }

        System.out.println("\n\n");
    }

    /**
     * play a round of rps
     */
    private void playRound() {
        //1rock, 2paper, 3scissors
        int playerChoice = enterChoice();
        int compChoice = (int) Math.floor(3*Math.random()) + 1;

        String pChoiceText = choiceMap.get(playerChoice);
        String cChoiceText = choiceMap.get(playerChoice);

        int winner = calculateRound(playerChoice, compChoice);

        //output result
        if (winner == -1) {
            draws++;
            System.out.println("Draw!");

        } else if (winner == 0) {
            playerWins++;
            System.out.printf("%s beats %s. Player wins!\n", pChoiceText, cChoiceText);

        } else { //winner == 1
            compWins++;
            System.out.printf("%s beats %s. Comp wins!\n", cChoiceText, pChoiceText);
        }
    }

    /**
     * calculate winner
     * @param pChoice player choice
     * @param cChoice computer choice
     * @return int winner (-1=draw, 0=player, 1=computer)
     */
    private int calculateRound(int pChoice, int cChoice){
        int winner = -1;//-1=draw, 0=player, 1=computer

        if (pChoice == cChoice){
            winner=-1;

        } else if (pChoice == 1) {
            winner = (cChoice == 2) ? 1 : 0;

        } else if (pChoice == 2) {
            winner = (cChoice == 1) ? 0 : 1;

        } else if (pChoice == 3) {
            winner = (cChoice == 1) ? 1 : 0;
        }

        return winner;
    }

    /**
     * user enter choice (1rock, 2paper, 3scissors)
     * @return player choice
     */
    private int enterChoice() {
        int playerEntry;

        do {
            System.out.print("1 Rock, 2 Paper, 3 Scissors. Enter :: ");
            playerEntry = myScanner.nextInt();
        } while (playerEntry < 1 || playerEntry > 3);

        return playerEntry;
    }

    /**
     * user enter num of rounds to play
     * @return number of rounds
     */
    private int enterNumRounds() {
        int numRounds;

        do {
            System.out.print("How many rounds :: ");
            numRounds = myScanner.nextInt();
        } while (numRounds < 1 || numRounds > 10);

        return numRounds;

    }


}