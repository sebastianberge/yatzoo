package yatzoo;

import java.util.List;

public class Score {

    public static long getScore(List<DiceValue> values, int round) {
        if (round >= 0 && round <= 5) {
            return getNumberOfAnimals(values, Animals.values()[round]);
        }
        switch (round) {
        case 6:
            for (Animals animal : Animals.values()) {
                if (getNumberOfAnimals(values, animal) >= 3) {
                    return 3;
                }
            }
            return 0;
        case 7:
            for (Animals animal : Animals.values()) {
                if (getNumberOfAnimals(values, animal) >= 4) {
                    return 4;
                }
            }
            return 0;
        case 8:
            int pairs = 0;
            for (Animals animal : Animals.values()) {
                if (getNumberOfAnimals(values, animal) >= 2) {
                    pairs++;
                }

            }
            return pairs >= 2 ? 4 : 0;
        case 9:
            int pairs_house = 0;
            int triples = 0;
            for (Animals animal : Animals.values()) {
                long numAnim = getNumberOfAnimals(values, animal);
                if (numAnim >= 3) {
                    triples++;
                } else if (numAnim >= 2) {
                    pairs_house++;
                }

            }
            return triples >= 1 && pairs_house >= 1 ? 5 : 0;
        case 10:

            long highest = 0;
            for (Animals animal : Animals.values()) {
                long numAnim = getNumberOfAnimals(values, animal);
                if (numAnim > highest) {
                    highest = numAnim;
                }

            }
            return highest == 1 ? 5 : 0;
        case 11:
            boolean yatzoo = true;
            Animals animal = values.get(0).animal;
            for (DiceValue val : values) {
                if (val.animal != animal) {
                    yatzoo = false;
                    break;
                }
            }
            return yatzoo ? 10 : 0;

        }

        return 0;
    }

    private static long getNumberOfAnimals(List<DiceValue> values, Animals animal) {
        return values.stream().filter(x -> x.getAnimal().equals(animal.toString())).count();
    }
}