package yatzoo;

/**
 * @author Sebastian Berge
 */
public class DiceValue {
    public final Animals animal;
    public final int value;

    public DiceValue(int value) {
        this.animal = Animals.values()[value];
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DiceValue)) {
            return false;
        } else {
            return this.animal == ((DiceValue) o).animal;
        }
    }

    @Override
    public String toString() {
        return animal.toString() + " " + value;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @return the animal
     */
    public Animals getAnimal() {
        return animal;
    }
}