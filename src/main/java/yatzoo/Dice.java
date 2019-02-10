package yatzoo;

import java.util.Random;
/**
 * Dice class that represents the dice and its current value.
 */
public class Dice {
    DiceValue currentValue = null;
    private Random random = new Random();

    /**
     * Constructor for class Dice
     */
    public Dice() {
        random = new Random();
    }

    /**
     * Returns the current value of the Dice.
     * Method for rolling the Dice.
     * @return currentValue
     */
    public DiceValue rollDice() {
        currentValue = new DiceValue(random.nextInt(6));
        return currentValue;
    }

    /**
     * Method for getting the current value of the dice.
     * @return currentValue
     */
    public DiceValue getCurrentValue() {
        return currentValue;
    }
}