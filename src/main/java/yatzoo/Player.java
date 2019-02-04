package yatzoo;

/**
 * @author Sebastian Berge
 */

public class Player {
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }
}