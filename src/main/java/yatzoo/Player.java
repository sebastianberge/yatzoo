package yatzoo;

import java.util.List;
import java.util.Scanner;
/**
 * Player class
 */
public class Player {
    private final String name;
    private long score;

    /**
     * Constructor for Player class.
     * @param name
     */
    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public void takeTurn(DicesADT diceCup, Round round, Scanner scanner) {
        List<DiceValue> diceValues = diceCup.rollDice();
        int rolls = 1;
        System.out
                .println("\n" + "Player: " + name + ", Round: " + (round.getCurrent() + 1) + "\n" + round.getString());
        System.out.println("Your dices are: ");
        System.out.println("______________________________________________________________________________");
        diceCup.getAllDiceValues().stream().forEach(System.out::println);
        System.out.println("______________________________________________________________________________");
        boolean isDone = false;
        while (rolls < 3 && !isDone) {
            System.out.println("Wirte the numbers with spaces of which animal nr you would like to keep.");
            String answer = scanner.nextLine();

            if (!answer.isEmpty() && !answer.equals("") && !answer.equals(" ")) {
                String[] keep = answer.split(" ");
                for (int i = 0; i < keep.length; i++) {

                    int keepInt;

                    try {
                        keepInt = Integer.parseInt(keep[i]);
                    } catch (NumberFormatException e) {
                        continue;
                    }

                    diceCup.keepDice(diceValues.stream().filter(y -> y.getValue() == keepInt).findAny().orElse(null));
                }
                diceValues = diceCup.rollDice();
                rolls++;
                System.out.println("______________________________________________________________________________");
                diceCup.getAllDiceValues().stream().forEach(System.out::println);
                System.out.println("______________________________________________________________________________");
            } else {
                diceValues = diceCup.rollDice();
                rolls++;
                System.out.println("______________________________________________________________________________");
                diceCup.getAllDiceValues().stream().forEach(System.out::println);
                System.out.println("______________________________________________________________________________");
            }
        }
        long roundScore = Score.getScore(diceCup.getAllDiceValues(), round.getCurrent());
        score += roundScore;
        System.out.println("Your score this round is: " + roundScore);
        System.out.println("Your total score is: " + score);
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return score
     */
    public long getScore() {
        return score;
    }
}