package Model;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int diceCount;
    int min = 1;
    int max = 6;

    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int rollDice() {
        int diceRolled = 0;
        int totalSum = 0;
        while (diceRolled < this.diceCount) {
            int diceNumber = ThreadLocalRandom.current().nextInt(min, max);
            totalSum += diceNumber;
            diceRolled++;
        }
        return totalSum;
    }
}
