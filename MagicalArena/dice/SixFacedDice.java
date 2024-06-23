package dice;

public class SixFacedDice implements Dice{
    private static final int MAX_FACES = 6;
    public SixFacedDice() {
    }

    @Override
    public int rollDice() {
        int diceFaceValue = (int)((Math.random()*(MAX_FACES-1))+1); // roll a dice
        return diceFaceValue;
    }
}