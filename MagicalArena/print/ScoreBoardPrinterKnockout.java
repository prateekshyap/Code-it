package print;

import player.Player;

import match.Single;
import match.ScoreBoard;
import match.ScoreBoardKnockout;

public class ScoreBoardPrinterKnockout implements ScoreBoardPrinter {
    private static final int MAX_FIXED_ROW_LENGTH = 83; // length of the heading row
    private static final int HALF_LENGTH = 41;
    private static final int MAX_MESSAGE_LENGTH = 15;
    private static final int MESSAGE_SPACE_1 = 8, MESSAGE_SPACE_2 = 10;

    @Override
    public void printScoreBoardToConsole(Single match) {
        System.out.println();
        ScoreBoard scoreBoard = match.getScoreBoard();
        Player[] players = match.getPlayers();
        Player player1 = players[0];
        Player player2 = players[1];
        int totalRounds = scoreBoard.getIndex();
        int[] healthPlayer1 = scoreBoard.getHealthPlayer1();
        int[] damagePlayer1 = scoreBoard.getDamagePlayer1();
        int[] healthPlayer2 = scoreBoard.getHealthPlayer2();
        int[] damagePlayer2 = scoreBoard.getDamagePlayer2();
        int[] attackingDicePlayer1 = scoreBoard.getAttackingDicePlayer1();
        int[] attackingDicePlayer2 = scoreBoard.getAttackingDicePlayer2();
        int[] defendingDicePlayer1 = scoreBoard.getDefendingDicePlayer1();
        int[] defendingDicePlayer2 = scoreBoard.getDefendingDicePlayer2();

        //+--------------------------------+
        StringBuffer consoleBuffer = new StringBuffer();
        consoleBuffer.append("+");
        for (int col = 0; col < HALF_LENGTH-1; ++col) {
            consoleBuffer.append("-");
        }
        consoleBuffer.append("+");
        for (int col = 0; col < HALF_LENGTH-1; ++col) {
            consoleBuffer.append("-");
        }
        consoleBuffer.append("+");
        System.out.println(consoleBuffer.toString());

        //player details
        consoleBuffer = new StringBuffer();
        consoleBuffer.append("|");
        String name = player1.getName();
        for (int i = 0; i < (HALF_LENGTH-(name.length()+MAX_MESSAGE_LENGTH))/2; ++i) {
            consoleBuffer.append(" ");
        }
        if (name.length() > MAX_MESSAGE_LENGTH) {
            consoleBuffer.append(name.substring(0,MAX_MESSAGE_LENGTH));
        }
        else {
            consoleBuffer.append(name);
        }
        consoleBuffer.append("'s attack (");
        consoleBuffer.append(player1.getStrength());
        consoleBuffer.append(")");
        for (int i = 0; i < (HALF_LENGTH-(name.length()+MAX_MESSAGE_LENGTH))/2; ++i) {
            consoleBuffer.append(" ");
        }
        while (consoleBuffer.length() < HALF_LENGTH) {
            consoleBuffer.append(" ");
        }
        consoleBuffer.append("|");
        name = player2.getName();
        for (int i = 0; i < (HALF_LENGTH-(name.length()+MAX_MESSAGE_LENGTH))/2; ++i) {
            consoleBuffer.append(" ");
        }
        if (name.length() > MAX_MESSAGE_LENGTH) {
            consoleBuffer.append(name.substring(0,MAX_MESSAGE_LENGTH));
        }
        else {
            consoleBuffer.append(name);
        }
        consoleBuffer.append("'s attack (");
        consoleBuffer.append(player2.getStrength());
        consoleBuffer.append(")");
        for (int i = 0; i < (HALF_LENGTH-(name.length()+MAX_MESSAGE_LENGTH))/2; ++i) {
            consoleBuffer.append(" ");
        }
        while (consoleBuffer.length() < MAX_FIXED_ROW_LENGTH-1) {
            consoleBuffer.append(" ");
        }
        consoleBuffer.append("|");
        System.out.println(consoleBuffer.toString());

        //+--------------------------------+
        consoleBuffer = new StringBuffer();
        consoleBuffer.append("+");
        for (int col = 0; col < HALF_LENGTH-1; ++col) {
            consoleBuffer.append("-");
        }
        consoleBuffer.append("+");
        for (int col = 0; col < HALF_LENGTH-1; ++col) {
            consoleBuffer.append("-");
        }
        consoleBuffer.append("+");
        System.out.println(consoleBuffer.toString());

        //heading row
        consoleBuffer = new StringBuffer("| Attacking  Damage  Defending  Opponent | Attacking  Damage  Defending  Opponent |");
        consoleBuffer.append("\n|      Dice               Dice    Health |      Dice               Dice    Health |");
        System.out.println(consoleBuffer.toString());

        //+--------------------------------+
        consoleBuffer = new StringBuffer();
        consoleBuffer.append("+");
        for (int col = 0; col < HALF_LENGTH-1; ++col) {
            consoleBuffer.append("-");
        }
        consoleBuffer.append("+");
        for (int col = 0; col < HALF_LENGTH-1; ++col) {
            consoleBuffer.append("-");
        }
        consoleBuffer.append("+");
        System.out.println(consoleBuffer.toString());

        // print all round details
        for (int r = 0; r < totalRounds; ++r) {
            consoleBuffer = new StringBuffer();
            consoleBuffer.append("|");
            if (damagePlayer1[r] == 0) {
                for (int i = 0; i < HALF_LENGTH-1; ++i) {
                    consoleBuffer.append(" ");
                }
                consoleBuffer.append("|         ");
                consoleBuffer.append(attackingDicePlayer2[r]);
                String damageStr = Integer.toString(damagePlayer2[r]);
                for (int i = 0; i < MESSAGE_SPACE_1-damageStr.length(); ++i) {
                    consoleBuffer.append(" ");
                }
                consoleBuffer.append(damageStr);
                consoleBuffer.append("          ");
                consoleBuffer.append(defendingDicePlayer1[r]);
                String healthStr = Integer.toString(healthPlayer1[r]);
                if (r == totalRounds-1) {
                    healthStr = "0";
                }
                for (int i = 0; i < MESSAGE_SPACE_2-healthStr.length(); ++i) {
                    consoleBuffer.append(" ");
                }
                consoleBuffer.append(healthStr);
                consoleBuffer.append(" ");
            }
            else {
                consoleBuffer.append("         ");
                consoleBuffer.append(attackingDicePlayer1[r]);
                String damageStr = Integer.toString(damagePlayer1[r]);
                for (int i = 0; i < MESSAGE_SPACE_1-damageStr.length(); ++i) {
                    consoleBuffer.append(" ");
                }
                consoleBuffer.append(damageStr);
                consoleBuffer.append("          ");
                consoleBuffer.append(defendingDicePlayer2[r]);
                String healthStr = Integer.toString(healthPlayer2[r]);
                if (r == totalRounds-1) {
                    healthStr = "0";
                }
                for (int i = 0; i < MESSAGE_SPACE_2-healthStr.length(); ++i) {
                    consoleBuffer.append(" ");
                }
                consoleBuffer.append(healthStr);
                consoleBuffer.append(" |");
                for (int i = 0; i < HALF_LENGTH-1; ++i) {
                    consoleBuffer.append(" ");
                }
            }
            consoleBuffer.append("|");
            System.out.println(consoleBuffer.toString());
        }
        
        //+--------------------------------+
        consoleBuffer = new StringBuffer();
        consoleBuffer.append("+");
        for (int col = 0; col < HALF_LENGTH-1; ++col) {
            consoleBuffer.append("-");
        }
        consoleBuffer.append("+");
        for (int col = 0; col < HALF_LENGTH-1; ++col) {
            consoleBuffer.append("-");
        }
        consoleBuffer.append("+");
        System.out.println(consoleBuffer.toString());
    }

    @Override
    public void printScoreBoardToFile() {

    }
}