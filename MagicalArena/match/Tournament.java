package match;

import player.Player;

import dice.Dice;
import dice.SixFacedDice;

import match.Single;
import match.Series;
import match.Knockout;

public class Tournament implements Series {
    private static final int TOTAL_KNOCKOUTS = 7; //4 leagues, 2 semis, 1 finale
    private static final int LEAGUE_PLAYER_COUNT = 8;
    private static final int SEMI_FINALE_PLAYER_COUNT = 4;
    private static final int FINALE_PLAYER_COUNT = 2;
    private Player[] player;
    private Player[] semiFinalePlayer;
    private Player[] finalePlayer;
    private Player winner;
    private Dice attackingDice, defendingDice;
    private int[] seq1 = new int[]{0,1,2,5,3,6,4,7};
    private int[] seq2 = new int[]{0,3,1,2};
    private Single[] matches;

    public Tournament(Player[] player) throws Exception {
        if (player.length != 8) {
            throw new LengthDoesNotMatchException("Number of players should be 8.");
        }
        for (int p = 0; p < LEAGUE_PLAYER_COUNT; ++p) {
            if (player[p] == null) {
                throw new NullPointerException("Player "+p+" cannot be empty.");
            }
        }
        this.player = player;
        this.semiFinalePlayer = new Player[SEMI_FINALE_PLAYER_COUNT];
        this.finalePlayer = new Player[FINALE_PLAYER_COUNT];
        this.attackingDice = new SixFacedDice();
        this.defendingDice = new SixFacedDice();
        this.matches = new Single[TOTAL_KNOCKOUTS]; // composite design pattern
    }

    @Override
    public void play() {
        //league matches
        for (int matchSeq = 0; matchSeq < SEMI_FINALE_PLAYER_COUNT; ++matchSeq) {
            try {
            this.matches[matchSeq] = new Knockout(this.player[seq1[matchSeq*2]], this.player[seq1[(matchSeq*2)+1]]);
            }catch(Exception e){}
            this.matches[matchSeq].play();
            if (this.player[seq1[matchSeq*2]].getHealth() <= 0) {
                this.semiFinalePlayer[matchSeq] = this.player[seq1[(matchSeq*2)+1]];
            }
            else {
                this.semiFinalePlayer[matchSeq] = this.player[seq1[matchSeq*2]];
            }
            this.player[seq1[matchSeq*2]].restoreStatus();
            this.player[seq1[(matchSeq*2)+1]].restoreStatus();
        }

        //semifinale
        for (int matchSeq = 0; matchSeq < FINALE_PLAYER_COUNT; ++matchSeq) {
            try{
            this.matches[matchSeq+4] = new Knockout(this.semiFinalePlayer[seq2[matchSeq*2]], this.semiFinalePlayer[seq2[(matchSeq*2)+1]]);
            }catch(Exception e){}
            this.matches[matchSeq+4].play();
            if (this.semiFinalePlayer[seq2[matchSeq*2]].getHealth() <= 0) {
                this.finalePlayer[matchSeq] = this.semiFinalePlayer[seq2[(matchSeq*2)+1]];
            }
            else {
                this.finalePlayer[matchSeq] = this.semiFinalePlayer[seq2[matchSeq*2]];
            }
            this.semiFinalePlayer[seq2[matchSeq*2]].restoreStatus();
            this.semiFinalePlayer[seq2[(matchSeq*2)+1]].restoreStatus();
        }

        //finale
        try{
        this.matches[TOTAL_KNOCKOUTS-1] = new Knockout(this.finalePlayer[0], this.finalePlayer[1]);
        }catch(Exception e){}
        this.matches[TOTAL_KNOCKOUTS-1].play();

        if (this.finalePlayer[0].getHealth() <= 0) {
            winner = this.finalePlayer[1];
        }
        else {
            winner = this.finalePlayer[0];
        }
    }

    @Override
    public Single[] getAllMatches() {
        return this.matches;
    }
    
    @Override
    public Player[] getPlayers() {
        return this.player;
    }

    @Override
    public Player getWinner() {
        return this.winner;
    }
}

class LengthDoesNotMatchException extends Exception {
    public LengthDoesNotMatchException(String msg) {
        super(msg);
    }
}