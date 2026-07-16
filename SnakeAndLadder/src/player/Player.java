package player;

import board.Pawn;
import board.Board;

public class Player {
    String name;
    Pawn pawn;
    int position;

    public Player(String name) {
        this.name = name;
        this.pawn = new Pawn();
        this.position = 0;
    }

    public int getPosition() { return this.position; }

    public String getName() {
        return this.name;
    }

    public boolean move(Board board, int diceValue) {
        this.position += diceValue;

        if (this.position == board.getRow()*board.getCol()) {
            return true;
        }

        if (this.position >= board.getRow()*board.getCol()) {
            this.position -= diceValue;
            return false;
        }

        int isSnake = board.isSnake(position);

        if (isSnake != -1) {
            this.position = isSnake;
        }

        int isLadder = board.isLadder(position);

        if (isLadder != -1) {
            this.position = isLadder;
        }

        return false;
    }
}
