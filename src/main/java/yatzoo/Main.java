package yatzoo;

import java.util.Scanner;
/**
 * Main class for the Yatzoo game.
 */
public class Main {

    public static void main(String[] args) {
        Player[] players = initPlayers(args);
        new Controller(players);
    }

    // Only public for unitTest
    public static Player[] initPlayers(String[] args) {
        Player[] players = null;
        Scanner scanner = new Scanner(System.in);

        // Initialize players from args
        if (args.length >= 2 && args.length <= 5) {
            players = new Player[args.length];
            for (int index = 0; index < args.length; index++) {
                players[index] = new Player(args[index]);
            }

        } else {
            int num_players = 0;
            do {
                System.out.println("Number of players [2-5]: ");
                String input = scanner.nextLine();

                if (input != null && input.length() == 1) {
                    try {
                        num_players = Integer.parseInt(input);
                        if (num_players < 2 || num_players > 5) {
                            System.out.println("Invalid nr of players!");

                        }
                    } catch (NumberFormatException e) {
                        num_players = 0;
                    }
                }
            } while (num_players < 2 || num_players > 5);
            players = new Player[num_players];

            for (int index = 0; index < num_players; index++) {
                System.out.println("Name of player #" + (index + 1));
                String playerName = scanner.nextLine();
                players[index] = new Player(playerName);
            }
        }
        return players;
    }

}
