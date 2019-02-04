package yatzoo;

import java.util.ArrayList;
import java.util.List;

public class Dices implements DicesADT {
    List<Dice> dices;
    List<Dice> dicesToKeep;
    int ant;

    boolean isRolled;

    public Dices(int ant) {
        this.ant = ant;
        isRolled = false;
        dices = new ArrayList<Dice>();
        for (int a = 0; a < ant; a++) {
            dices.add(new Dice());
        }
        dicesToKeep = new ArrayList<Dice>();

    }

    @Override
    public List<DiceValue> rollDice() {
        isRolled = true;
        List<DiceValue> values = new ArrayList<DiceValue>();
        for (int index = 0; index < dices.size(); index++) {
            values.add(dices.get(index).rollDice());
        }
        return values;
    }

    @Override
    public boolean keepDice(DiceValue diceValueToKeep) {
        boolean success = false;
        Dice diceToKeep = null;
        for (Dice dice : dices) {
            if (dice.getCurrentValue().equals(diceValueToKeep)) {

                success = true;
                diceToKeep = dice;
                break;
            }
        }
        if (success) {
            dices.remove(diceToKeep);
            dicesToKeep.add(diceToKeep);
        }
        return success;
    }

    @Override
    public boolean unkeepDice(DiceValue diceValueToUnkeep) {
        Dice diceToPutBackInCup = null;
        boolean success = false;
        for (Dice diceInKeepList : dicesToKeep) {
            if (diceInKeepList.getCurrentValue().equals(diceValueToUnkeep)) {
                diceToPutBackInCup = diceInKeepList;
                success = true;
                break;
            }
        }
        if (success) {
            dicesToKeep.remove(diceToPutBackInCup);
            dices.add(diceToPutBackInCup);
        }
        return success;
    }

    @Override
    public void reset() {
        isRolled = false;
        dices = new ArrayList<Dice>();
        for (int a = 0; a < ant; a++) {
            dices.add(new Dice());
        }
        dicesToKeep = new ArrayList<Dice>();
    }

    @Override
    public List<DiceValue> getAllDiceValues() {
        if (!isRolled) {
            return null;
        }
        List<DiceValue> diceValues = new ArrayList<DiceValue>();
        for (Dice dice : dicesToKeep) {
            diceValues.add(dice.currentValue);
        }
        for (Dice dice : dices) {
            diceValues.add(dice.currentValue);
        }
        return diceValues;
    }
}