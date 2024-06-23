package match;

import player.Player;
import player.PlayerImpl;

import match.Single;
import match.Knockout;
import match.ScoreBoard;

class TestKnockout {
    public static void main(String[] args) throws Exception {
        TestKnockout test = new TestKnockout();
        Player testPlayer1 = new PlayerImpl("Test1",50,5,10);
        Player testPlayer2 = new PlayerImpl("Test2",100,10,5);
        test.testCreateKnockout(testPlayer1,null);
        test.testCreateKnockout(null,testPlayer2);
        Single match = null;
        match = new Knockout(testPlayer1,testPlayer2);
        test.testPlay(match);
    }
    void testCreateKnockout(Player player1, Player player2) {
        try {
        Single match = new Knockout(player1,player2);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    void testPlay(Single match) {
        match.play();
        ScoreBoard scoreBoard = match.getScoreBoard();
        int totalRounds = scoreBoard.getIndex();
        int[] healthPlayer1 = scoreBoard.getHealthPlayer1();
        int[] damagePlayer1 = scoreBoard.getDamagePlayer1();
        int[] healthPlayer2 = scoreBoard.getHealthPlayer2();
        int[] damagePlayer2 = scoreBoard.getDamagePlayer2();
        int[] attackingDicePlayer1 = scoreBoard.getAttackingDicePlayer1();
        int[] attackingDicePlayer2 = scoreBoard.getAttackingDicePlayer2();
        int[] defendingDicePlayer1 = scoreBoard.getDefendingDicePlayer1();
        int[] defendingDicePlayer2 = scoreBoard.getDefendingDicePlayer2();
        Player[] player = match.getPlayers();
        boolean turn = true; //true indicates player1's attack
        for (int r = 0; r < totalRounds; ++r) {
            if (turn) {
                if (damagePlayer2[r] != 0 || attackingDicePlayer2[r] != 0 || defendingDicePlayer1[r] != 0 ||
                    damagePlayer1[r] == 0 || attackingDicePlayer1[r] == 0 || defendingDicePlayer2[r] == 0) {
                        System.out.println("Unexpected values."+turn+r);
                        return;
                }
            }
            else {
                if (damagePlayer1[r] != 0 || attackingDicePlayer1[r] != 0 || defendingDicePlayer2[r] != 0 ||
                    damagePlayer2[r] == 0 || attackingDicePlayer2[r] == 0 || defendingDicePlayer1[r] == 0) {
                        System.out.println("Unexpected values."+turn+r);
                        return;
                }
            }
            turn = !turn;
        }
        System.out.println("Passed.");
    }
}