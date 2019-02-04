package yatzoo;

import java.util.List;

public interface DicesADT {

    public List<DiceValue> rollDice();

    public boolean keepDice(DiceValue diceValueToKeep);

    public boolean unkeepDice(DiceValue diceValueToUnKeep);

    public void reset();

    public List<DiceValue> getAllDiceValues();
}