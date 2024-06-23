package match;

import player.Player;

public class ScoreBoardKnockout implements ScoreBoard {
    private static final int INITIAL_CAPACITY = 10;
    private int[] healthPlayer1, healthPlayer2;
    private int[] damagePlayer1, damagePlayer2;
    private int[] attackingDicePlayer1, attackingDicePlayer2;
    private int[] defendingDicePlayer1, defendingDicePlayer2;
    private int turnIndex, capacity;
    
    public ScoreBoardKnockout() {
        this.capacity = this.INITIAL_CAPACITY;
        this.healthPlayer1 = new int[capacity];
        this.damagePlayer1 = new int[capacity];
        this.healthPlayer2 = new int[capacity];
        this.damagePlayer2 = new int[capacity];
        this.attackingDicePlayer1 = new int[capacity];
        this.attackingDicePlayer2 = new int[capacity];
        this.defendingDicePlayer1 = new int[capacity];
        this.defendingDicePlayer2 = new int[capacity];
        this.turnIndex = 0;
    }

    @Override
    public void storePlayer1AttackData(Player player1, Player player2, int attackingDiceFaceValue, int defendingDiceFaceValue) {
        resize();
        this.healthPlayer1[turnIndex] = player1.getHealth();
        this.healthPlayer2[turnIndex] = player2.getHealth();
        this.damagePlayer1[turnIndex] = attackingDiceFaceValue*player1.getAttack();
        this.attackingDicePlayer1[turnIndex] = attackingDiceFaceValue;
        this.defendingDicePlayer2[turnIndex] = defendingDiceFaceValue;
        ++turnIndex;
    }

    @Override
    public void storePlayer2AttackData(Player player2, Player player1, int attackingDiceFaceValue, int defendingDiceFaceValue) {
        resize();
        this.healthPlayer1[turnIndex] = player1.getHealth();
        this.healthPlayer2[turnIndex] = player2.getHealth();
        this.damagePlayer2[turnIndex] = attackingDiceFaceValue*player2.getAttack();
        this.attackingDicePlayer2[turnIndex] = attackingDiceFaceValue;
        this.defendingDicePlayer1[turnIndex] = defendingDiceFaceValue;
        ++turnIndex;
    }

    @Override
    public int getIndex() {
        return this.turnIndex;
    }

    @Override
    public int[] getHealthPlayer1() {
        return this.healthPlayer1;
    }

    @Override
    public int[] getDamagePlayer1() {
        return this.damagePlayer1;
    }

    @Override
    public int[] getHealthPlayer2() {
        return this.healthPlayer2;
    }

    @Override
    public int[] getDamagePlayer2() {
        return this.damagePlayer2;
    }

    @Override
    public int[] getAttackingDicePlayer1() {
        return this.attackingDicePlayer1;
    }

    @Override
    public int[] getAttackingDicePlayer2() {
        return this.attackingDicePlayer2;
    }

    @Override
    public int[] getDefendingDicePlayer1() {
        return this.defendingDicePlayer1;
    }

    @Override
    public int[] getDefendingDicePlayer2() {
        return this.defendingDicePlayer2;
    }

    private void resize() {
        if (turnIndex == capacity) {
            capacity *= 2;
            int[] newHealthPlayer1 = new int[capacity];
            int[] newDamagePlayer1 = new int[capacity];
            int[] newHealthPlayer2 = new int[capacity];
            int[] newDamagePlayer2 = new int[capacity];
            int[] newAttackingDicePlayer1 = new int[capacity];
            int[] newAttackingDicePlayer2 = new int[capacity];
            int[] newDefendingDicePlayer1 = new int[capacity];
            int[] newDefendingDicePlayer2 = new int[capacity];
            for (int i = 0; i < this.healthPlayer1.length; ++i) {
                newHealthPlayer1[i] = this.healthPlayer1[i];
                newDamagePlayer1[i] = this.damagePlayer1[i];
                newHealthPlayer2[i] = this.healthPlayer2[i];
                newDamagePlayer2[i] = this.damagePlayer2[i];
                newAttackingDicePlayer1[i] = this.attackingDicePlayer1[i];
                newAttackingDicePlayer2[i] = this.attackingDicePlayer2[i];
                newDefendingDicePlayer1[i] = this.defendingDicePlayer1[i];
                newDefendingDicePlayer2[i] = this.defendingDicePlayer2[i];
            }
            this.healthPlayer1 = newHealthPlayer1;
            this.damagePlayer1 = newDamagePlayer1;
            this.healthPlayer2 = newHealthPlayer2;
            this.damagePlayer2 = newDamagePlayer2;
            this.attackingDicePlayer1 = newAttackingDicePlayer1;
            this.attackingDicePlayer2 = newAttackingDicePlayer2;
            this.defendingDicePlayer1 = newDefendingDicePlayer1;
            this.defendingDicePlayer2 = newDefendingDicePlayer2;
        }
    }
}