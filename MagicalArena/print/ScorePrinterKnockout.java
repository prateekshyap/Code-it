package print;

import player.Player;

import match.Single;

public class ScorePrinterKnockout implements ScorePrinter {
    private static final int MAX_FIXED_ROW_LENGTH = 21; // 21 is the maximum length of the rows printing the health and the attack count
    private static final int SPACE_COUNT = 15; // spaces around the data
    private static final int MIN_UNDERLINE_LENGTH = 5;

    @Override
    public void printScoreToConsole(Single match) {
        System.out.println();
        Player[] players = match.getPlayers();
        Player player1 = players[0];
        Player player2 = players[1];
        int maxRowLength = Math.max(MAX_FIXED_ROW_LENGTH,Math.max(player1.getName().length(),player2.getName().length()))+SPACE_COUNT;
        
        //+--------------------------------+
        StringBuffer consoleBuffer = new StringBuffer();
        consoleBuffer.append("+");
        for (int col = 0; col < maxRowLength-2; ++col) {
            consoleBuffer.append("-");
        }
        consoleBuffer.append("+");
        System.out.println(consoleBuffer.toString());

        //player1 name
        consoleBuffer = new StringBuffer();
        consoleBuffer.append("|    ");
        consoleBuffer.append(player1.getName());
        int remainingLength = maxRowLength-consoleBuffer.length();
        for (int col = 0; col < remainingLength-1; ++col) {
            consoleBuffer.append(" ");
        }
        consoleBuffer.append("|");
        System.out.println(consoleBuffer);

        //---------------------------
        consoleBuffer = new StringBuffer();
        consoleBuffer.append("|    ");
        for (int col = 0; col < Math.max(MIN_UNDERLINE_LENGTH,player1.getName().length()); ++col) {
            consoleBuffer.append("-");
        }
        remainingLength = maxRowLength-consoleBuffer.length();
        for (int col = 0; col < remainingLength-1; ++col) {
            consoleBuffer.append(" ");
        }
        consoleBuffer.append("|");
        System.out.println(consoleBuffer);

        //total attacks
        consoleBuffer = new StringBuffer();
        consoleBuffer.append("|    Total Attacks: ");
        consoleBuffer.append(player1.getAttackCount());
        remainingLength = maxRowLength-consoleBuffer.length();
        for (int col = 0; col < remainingLength-1; ++col) {
            consoleBuffer.append(" ");
        }
        consoleBuffer.append("|");
        System.out.println(consoleBuffer);
        
        //total remaining health
        consoleBuffer = new StringBuffer();
        consoleBuffer.append("|    Remaining Health: ");
        consoleBuffer.append(Math.max(0,player1.getHealth()));
        remainingLength = maxRowLength-consoleBuffer.length();
        for (int col = 0; col < remainingLength-1; ++col) {
            consoleBuffer.append(" ");
        }
        consoleBuffer.append("|");
        System.out.println(consoleBuffer);

        //blank line
        consoleBuffer = new StringBuffer();
        consoleBuffer.append("|");
        for (int col = 0; col < maxRowLength-2; ++col) {
            consoleBuffer.append(" ");
        }
        consoleBuffer.append("|");
        System.out.println(consoleBuffer);
        
        //player2 name
        consoleBuffer = new StringBuffer();
        consoleBuffer.append("|    ");
        consoleBuffer.append(player2.getName());
        remainingLength = maxRowLength-consoleBuffer.length();
        for (int col = 0; col < remainingLength-1; ++col) {
            consoleBuffer.append(" ");
        }
        consoleBuffer.append("|");
        System.out.println(consoleBuffer);

        //----------------------------
        consoleBuffer = new StringBuffer();
        consoleBuffer.append("|    ");
        for (int col = 0; col < Math.max(MIN_UNDERLINE_LENGTH,player2.getName().length()); ++col) {
            consoleBuffer.append("-");
        }
        remainingLength = maxRowLength-consoleBuffer.length();
        for (int col = 0; col < remainingLength-1; ++col) {
            consoleBuffer.append(" ");
        }
        consoleBuffer.append("|");
        System.out.println(consoleBuffer);

        //total attacks
        consoleBuffer = new StringBuffer();
        consoleBuffer.append("|    Total Attacks: ");
        consoleBuffer.append(player2.getAttackCount());
        remainingLength = maxRowLength-consoleBuffer.length();
        for (int col = 0; col < remainingLength-1; ++col) {
            consoleBuffer.append(" ");
        }
        consoleBuffer.append("|");
        System.out.println(consoleBuffer);
        
        //total remaining health
        consoleBuffer = new StringBuffer();
        consoleBuffer.append("|    Remaining Health: ");
        consoleBuffer.append(Math.max(0,player2.getHealth()));
        remainingLength = maxRowLength-consoleBuffer.length();
        for (int col = 0; col < remainingLength-1; ++col) {
            consoleBuffer.append(" ");
        }
        consoleBuffer.append("|");
        System.out.println(consoleBuffer);

        //+-------------------------------------+
        consoleBuffer = new StringBuffer();
        consoleBuffer.append("+");
        for (int col = 0; col < maxRowLength-2; ++col) {
            consoleBuffer.append("-");
        }
        consoleBuffer.append("+");
        System.out.println(consoleBuffer);

        //winner name
        consoleBuffer = new StringBuffer();
        consoleBuffer.append("|    ");
        if (match.getWinner() == player1) {
            consoleBuffer.append(player1.getName());
        }
        else {
            consoleBuffer.append(player2.getName());
        }
        consoleBuffer.append(" won!");
        remainingLength = maxRowLength-consoleBuffer.length();
        for (int col = 0; col < remainingLength-1; ++col) {
            consoleBuffer.append(" ");
        }
        consoleBuffer.append("|");
        System.out.println(consoleBuffer);

        //+------------------------------------+
        consoleBuffer = new StringBuffer();
        consoleBuffer.append("+");
        for (int col = 0; col < maxRowLength-2; ++col) {
            consoleBuffer.append("-");
        }
        consoleBuffer.append("+");
        System.out.println(consoleBuffer.toString());
    }

    @Override
    public void printScoreToFile() {

    }
}