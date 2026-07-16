import board.Dice;
import board.Board;
import player.Player;

public class SnakeAndLadder {
    public static void main(String[] args) {
        Dice dice = new Dice();

        Player red = new Player("Red");
        Player blue = new Player("Blue");
        Player green = new Player("Green");
        Player yellow = new Player("Yellow");

        Board board = new Board();
        int maxPosition = board.getMaxPosition();
        board.setPlayers(red, blue, green, yellow);
        int winnerCount = 2;

        System.out.println(board);

        while (winnerCount > 0) {
            // red turn
            int diceValue = dice.roll();
            if (diceValue == 6) diceValue += dice.roll();
            if (diceValue == 12) diceValue += dice.roll();
            if (diceValue != 18) {
                if (diceValue >= 6 || red.getPosition() != 0) {
                    boolean isWinner = red.move(board, diceValue);
                    if (isWinner) {
                        System.out.println(red.getName()+" won!");
                        --winnerCount;
                    }
                }
            }

//            System.out.println(board);

            //blue turn
            diceValue = dice.roll();
            if (diceValue == 6) diceValue += dice.roll();
            if (diceValue == 12) diceValue += dice.roll();
            if (diceValue != 18) {
                if (diceValue >= 6 || blue.getPosition() != 0) {
                    boolean isWinner = blue.move(board, diceValue);
                    if (isWinner) {
                        System.out.println(blue.getName()+" won!");
                        --winnerCount;
                    }
                }
            }

//            System.out.println(board);

            //green turn
            diceValue = dice.roll();
            if (diceValue == 6) diceValue += dice.roll();
            if (diceValue == 12) diceValue += dice.roll();
            if (diceValue != 18) {
                if (diceValue >= 6 || green.getPosition() != 0) {
                    boolean isWinner = green.move(board, diceValue);
                    if (isWinner) {
                        System.out.println(green.getName()+" won!");
                        --winnerCount;
                    }
                }
            }

//            System.out.println(board);

            //yellow turn
            diceValue = dice.roll();
            if (diceValue == 6) diceValue += dice.roll();
            if (diceValue == 12) diceValue += dice.roll();
            if (diceValue != 18) {
                if (diceValue >= 6 || yellow.getPosition() != 0) {
                    boolean isWinner = yellow.move(board, diceValue);
                    if (isWinner) {
                        System.out.println(yellow.getName()+" won!");
                        --winnerCount;
                    }
                }
            }

//            System.out.println(board);
        }
    }
}
