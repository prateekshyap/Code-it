package match;

import player.Player;

import dice.Dice;
import dice.SixFacedDice;

import match.ScoreBoard;
import match.ScoreBoardKnockout;

public class Knockout implements Single {
    private Player player[];
    private Dice attackingDice, defendingDice;
    private ScoreBoard scoreBoard;
    private Player winner;

    public Knockout(Player player1, Player player2) throws Exception {
        player = new Player[2];
        if (player1 == null) {
            throw new NullPointerException("Player 1 cannot be empty.");
        }
        if (player2 == null) {
            throw new NullPointerException("Player 2 cannot be empty.");
        }
        this.player[0] = player1;
        this.player[1] = player2;
        this.attackingDice = new SixFacedDice();
        this.defendingDice = new SixFacedDice();
        this.scoreBoard = new ScoreBoardKnockout();
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Match between\n");
        buffer.append(this.player[0].getName());
        buffer.append(" and ");
        buffer.append(this.player[1].getName());
        buffer.append("\n");
        return buffer.toString();
    }

    @Override
    public void play() {
        boolean turn = true; //true indicates player1's attack
        if (this.player[0].getHealth() > this.player[1].getHealth()) { //change turn if 2nd player has less health
            turn = false;
        }
        while (this.player[0].getHealth() > 0 && this.player[1].getHealth() > 0) {
            int attackingDiceFaceValue = -1, defendingDiceFaceValue = -1;
            if (turn) {
                attackingDiceFaceValue = this.attackingDice.rollDice();
                int damage = this.player[0].attack(attackingDiceFaceValue);
                defendingDiceFaceValue = this.defendingDice.rollDice();
                this.player[1].defend(damage, defendingDiceFaceValue);
                this.scoreBoard.storePlayer1AttackData(this.player[0], this.player[1], attackingDiceFaceValue, defendingDiceFaceValue);
            }
            else {
                attackingDiceFaceValue = this.attackingDice.rollDice();
                int damage = this.player[1].attack(attackingDiceFaceValue);
                defendingDiceFaceValue = this.defendingDice.rollDice();
                this.player[0].defend(damage, defendingDiceFaceValue);
                this.scoreBoard.storePlayer2AttackData(this.player[1], this.player[0], attackingDiceFaceValue, defendingDiceFaceValue);
            }
            turn = !turn;
        }
        if (this.player[0].getHealth() <= 0) {
            winner = this.player[1];
        }
        else {
            winner = this.player[0];
        }
    }

    @Override
    public Player[] getPlayers() {
        return this.player;
    }

    @Override
    public ScoreBoard getScoreBoard() {
        return this.scoreBoard;
    }

    @Override
    public Player getWinner() {
        return this.winner;
    }
}