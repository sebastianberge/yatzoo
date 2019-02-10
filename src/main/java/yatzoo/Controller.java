package yatzoo;

import java.util.Scanner;
/**
 * Controller class for initializing and starting the game.
 */
public class Controller {

    private Player[] players;
    Round r;
    Scanner scanner;

    public Controller(Player[] players) {
        this.players = players;
        this.r = new Round();
        scanner = new Scanner(System.in);
        startGame();
        scanner.close();
    }

    private void startGame() {
        DicesADT diceCup = new Dices(5);
        for (int round = 0; round < 12; round++) {
            for (int playerTurn = 0; playerTurn < players.length; playerTurn++) {
                players[playerTurn].takeTurn(diceCup, r, scanner);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("An error occurred: " + e);
                }
                diceCup.reset();
            }
            r.nextRound();
        }

        Player winner = whoWon();
        System.out.println("______________________________________________________________________________");
        System.out.println("\n" + "The winner is: " + winner.getName() + " with " + winner.getScore() + " points!");

    }

    public Player whoWon() {
        Player winner = players[0];
        for (int i = 1; i < players.length; i++) {
            if (players[i].getScore() > winner.getScore()) {
                winner = players[i];
            }
        }
        return winner;
    }
}