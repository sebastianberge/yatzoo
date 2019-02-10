package yatzoo;

import java.util.List;
/**
 * Interface for Dices class.
 */
public interface DicesADT {

    /**
     * Rolls the dice and stores the values in a List.
     * @return values
     */
    public List<DiceValue> rollDice();

    /**
     * Stores the values of the dices that player wants to keep.
     * @param diceValueToKeep
     * @return success
     */
    public boolean keepDice(DiceValue diceValueToKeep);

    /**
     * Puts the dices that the player doesnt want to keep back.
     * @param diceValueToUnKeep
     * @return success
     */
    public boolean unkeepDice(DiceValue diceValueToUnKeep);

    /**
     * Reset. Creates a new ArrayList.
     */
    public void reset();

    /**
     * Returns all dice values.
     * @return diceValues
     */
    public List<DiceValue> getAllDiceValues();
}