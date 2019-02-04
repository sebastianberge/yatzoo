package yatzoo;

import java.util.Arrays;
import java.util.List;

/**
 * @author Simen Ostensen
 */

public class Round {

    private List<String> list;
    private int current;

    public Round() {
        this.list = Arrays.asList(new String("Roll as many Lions as possible!"),
                new String("Roll as many Snakes as possible!"), new String("Roll as many Pandas as possible!"),
                new String("Roll as many Pigs as possible!"), new String("Roll as many Elephants as possible!"),
                new String("Roll as many Whales as possible!"), new String("Roll three similar animals"),
                new String("Roll four similar animals"), new String("Roll a House"), new String("Roll a Straight"),
                new String("Roll a YATZOOO!!!"));
        this.current = 0;
    }

    public String getString() {
        return list.get(current);
    }

    public int getCurrent() {
        return current;
    }

    public void nextRound() {
        current++;
    }

}