package dice;

import dice.Dice;
import dice.SixFacedDice;

class TestSixFacedDice {
    private static final int MAX_FACES = 6;
    public static void main(String[] args) {
        TestSixFacedDice test = new TestSixFacedDice();
        Dice dice = new SixFacedDice();
        test.testRoll(dice);
    }
    public void testRoll(Dice dice) {
        boolean isValueWithinRange = true;
        for (int i = 0; i < 100; ++i) {
            int diceFaceValue = dice.rollDice();
            if (diceFaceValue < 1 || diceFaceValue > MAX_FACES) {
                isValueWithinRange = false;
                break;
            }
        }
        if (isValueWithinRange) {
            System.out.println("Passed.");
        }
        else {
            System.out.println("Dice value does not lie in the expected range in some roll.");
        }
    }
}