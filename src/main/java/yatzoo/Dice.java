package yatzoo;

import java.util.Random;

/**
 * @author Sebastian Berge
 */
public class Dice {
    DiceValue currentValue = null;
    private Random random = new Random();

    public Dice() {
        random = new Random();
    }

    public DiceValue rollDice() {
        currentValue = new DiceValue(random.nextInt(6));
        return currentValue;
    }

    /**
     * @return currentValue
     */
    public DiceValue getCurrentValue() {
        return currentValue;
    }
}