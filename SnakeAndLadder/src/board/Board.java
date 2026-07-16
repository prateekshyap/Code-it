package board;

import player.Player;

import java.util.HashMap;

public class Board {
    final int nums = 5;
    final int length = 10;

    Player red, blue, green, yellow;

    int numSnake, numLadder;
    int row, col;
    HashMap<Integer, Integer> ladder;
    HashMap<Integer, Integer> snake;

    public Board() {
        this.numLadder = this.numSnake = nums;
        this.row = this.col = length;
        ladder = new HashMap<>();
        snake = new HashMap<>();
        for (int l = 0; l < numLadder; ++l) {
            int start = 1 + (int)(Math.random() * ((col*(row-1) - 1) + 1));
            int end = (row+1) + (int)(Math.random() * ((row*col - (row+1) ) + 1));
            ladder.put(start, end);
        }

        for (int s = 0; s < numSnake; ++s) {
            int start = (row+1) + (int)(Math.random() * ((row*col - (row+1) ) + 1));
            int end = 1 + (int)(Math.random() * (( col*(row-1) - 1) + 1));
            snake.put(start, end);
        }
    }

    public int getMaxPosition() { return row*col; }

    public int getRow() { return this.row; }

    public int getCol() { return this.col; }

    public void setPlayers(Player red, Player blue, Player green, Player yellow) {
        this.red = red;
        this.blue = blue;
        this.green = green;
        this.yellow = yellow;
    }

    public int isSnake(int position) {
        if (snake.containsKey(position)) {
            return snake.get(position);
        }
        return -1;
    }

    public int isLadder(int position) {
        if (ladder.containsKey(position)) {
            return ladder.get(position);
        }
        return -1;
    }

    @Override
    public String toString() {
        int red = this.red.getPosition();
        int blue = this.blue.getPosition();
        int green = this.green.getPosition();
        int yellow = this.yellow.getPosition();

        StringBuffer buffer = new StringBuffer();

        //cell 91 to 100
        for (int i = 0; i < 31; ++i)
            buffer.append("- ");
        buffer.append("\n|");
        for (int i = 0; i < 10; ++i) {
//            for (int j = 0; j < 5; ++j)
            buffer.append(" ");
            buffer.append(Integer.toString(91+i));
            buffer.append((red == 91+i) ? "R" :
                    (blue == 91+i) ? "B" :
                    (green == 91+i) ? "G" :
                    (yellow == 91+i) ? "Y" : " ");
            buffer.append(" ");
            buffer.append("|");
        }
        buffer.append("\n|");
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 5; ++j)
                buffer.append(" ");
            buffer.append("|");
        }
        buffer.append("\n");

//cell 81 to 90
        for (int i = 0; i < 31; ++i)
            buffer.append("- ");
        buffer.append("\n|");
        for (int i = 0; i < 10; ++i) {
            buffer.append(" ");
            buffer.append(Integer.toString(81+9-i));
            buffer.append((red == 90-i) ? "R" :
                    (blue == 90-i) ? "B" :
                    (green == 90-i) ? "G" :
                    (yellow == 90-i) ? "Y" : " ");
            buffer.append(" ");
            buffer.append("|");
        }
        buffer.append("\n|");
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 5; ++j)
                buffer.append(" ");
            buffer.append("|");
        }
        buffer.append("\n");

//cell 71 to 80
        for (int i = 0; i < 31; ++i)
            buffer.append("- ");
        buffer.append("\n|");
        for (int i = 0; i < 10; ++i) {
            buffer.append(" ");
            buffer.append(Integer.toString(71+i));
            buffer.append((red == 71+i) ? "R" :
                    (blue == 71+i) ? "B" :
                    (green == 71+i) ? "G" :
                    (yellow == 71+i) ? "Y" : " ");
            buffer.append(" ");
            buffer.append("|");
        }
        buffer.append("\n|");
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 5; ++j)
                buffer.append(" ");
            buffer.append("|");
        }
        buffer.append("\n");

//cell 61 to 70
        for (int i = 0; i < 31; ++i)
            buffer.append("- ");
        buffer.append("\n|");
        for (int i = 0; i < 10; ++i) {
            buffer.append(" ");
            buffer.append(Integer.toString(61+9-i));
            buffer.append((red == 70-i) ? "R" :
                    (blue == 70-i) ? "B" :
                    (green == 70-i) ? "G" :
                    (yellow == 70-i) ? "Y" : " ");
            buffer.append(" ");
            buffer.append("|");
        }
        buffer.append("\n|");
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 5; ++j)
                buffer.append(" ");
            buffer.append("|");
        }
        buffer.append("\n");

//cell 51 to 60
        for (int i = 0; i < 31; ++i)
            buffer.append("- ");
        buffer.append("\n|");
        for (int i = 0; i < 10; ++i) {
            buffer.append(" ");
            buffer.append(Integer.toString(51+i));
            buffer.append((red == 51+i) ? "R" :
                    (blue == 51+i) ? "B" :
                    (green == 51+i) ? "G" :
                    (yellow == 51+i) ? "Y" : " ");
            buffer.append(" ");
            buffer.append("|");
        }
        buffer.append("\n|");
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 5; ++j)
                buffer.append(" ");
            buffer.append("|");
        }
        buffer.append("\n");

//cell 41 to 50
        for (int i = 0; i < 31; ++i)
            buffer.append("- ");
        buffer.append("\n|");
        for (int i = 0; i < 10; ++i) {
            buffer.append(" ");
            buffer.append(Integer.toString(41+9-i));
            buffer.append((red == 50-i) ? "R" :
                    (blue == 50-i) ? "B" :
                    (green == 50-i) ? "G" :
                    (yellow == 50-i) ? "Y" : " ");
            buffer.append(" ");
            buffer.append("|");
        }
        buffer.append("\n|");
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 5; ++j)
                buffer.append(" ");
            buffer.append("|");
        }
        buffer.append("\n");

//cell 31 to 40
        for (int i = 0; i < 31; ++i)
            buffer.append("- ");
        buffer.append("\n|");
        for (int i = 0; i < 10; ++i) {
            buffer.append(" ");
            buffer.append(Integer.toString(31+i));
            buffer.append((red == 31+i) ? "R" :
                    (blue == 31+i) ? "B" :
                    (green == 31+i) ? "G" :
                    (yellow == 31+i) ? "Y" : " ");
            buffer.append(" ");
            buffer.append("|");
        }
        buffer.append("\n|");
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 5; ++j)
                buffer.append(" ");
            buffer.append("|");
        }
        buffer.append("\n");

//cell 21 to 30
        for (int i = 0; i < 31; ++i)
            buffer.append("- ");
        buffer.append("\n|");
        for (int i = 0; i < 10; ++i) {
            buffer.append(" ");
            buffer.append(Integer.toString(21+9-i));
            buffer.append((red == 30-i) ? "R" :
                    (blue == 30-i) ? "B" :
                    (green == 30-i) ? "G" :
                    (yellow == 30-i) ? "Y" : " ");
            buffer.append(" ");
            buffer.append("|");
        }
        buffer.append("\n|");
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 5; ++j)
                buffer.append(" ");
            buffer.append("|");
        }
        buffer.append("\n");

//cell 11 to 20
        for (int i = 0; i < 31; ++i)
            buffer.append("- ");
        buffer.append("\n|");
        for (int i = 0; i < 10; ++i) {
            buffer.append(" ");
            buffer.append(Integer.toString(11+i));
            buffer.append((red == 11+i) ? "R" :
                    (blue == 11+i) ? "B" :
                    (green == 11+i) ? "G" :
                    (yellow == 11+i) ? "Y" : " ");
            buffer.append(" ");
            buffer.append("|");
        }
        buffer.append("\n|");
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 5; ++j)
                buffer.append(" ");
            buffer.append("|");
        }
        buffer.append("\n");

//cell 1 to 10
        for (int i = 0; i < 31; ++i)
            buffer.append("- ");
        buffer.append("\n|");
        buffer.append(" ");
        buffer.append(Integer.toString(10));
        buffer.append((red == 10) ? "R" :
                (blue == 10) ? "B" :
                (green == 10) ? "G" :
                (yellow == 10) ? "Y" : " ");
        buffer.append(" ");
        buffer.append("|");
        for (int i = 0; i < 9; ++i) {
            buffer.append(" ");
            buffer.append(" ");
            buffer.append(Integer.toString(1+8-i));
            buffer.append((red == 9-i) ? "R" :
                    (blue == 9-i) ? "B" :
                    (green == 9-i) ? "G" :
                    (yellow == 9-i) ? "Y" : " ");
            buffer.append(" ");
            buffer.append("|");
        }
        buffer.append("\n|");
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 5; ++j)
                buffer.append(" ");
            buffer.append("|");
        }
        buffer.append("\n");


        for (int i = 0; i < 31; ++i)
            buffer.append("- ");

        return buffer.toString();
    }
}
