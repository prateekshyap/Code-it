package match;

import player.Player;

public interface ScoreBoard {
    public void storePlayer1AttackData(Player player1, Player player2, int attackingDiceFaceValue, int defendingDiceFaceValue);
    public void storePlayer2AttackData(Player player2, Player player1, int attackingDiceFaceValue, int defendingDiceFaceValue);
    public int getIndex();
    public int[] getHealthPlayer1();
    public int[] getDamagePlayer1();
    public int[] getHealthPlayer2();
    public int[] getDamagePlayer2();
    public int[] getAttackingDicePlayer1();
    public int[] getAttackingDicePlayer2();
    public int[] getDefendingDicePlayer1();
    public int[] getDefendingDicePlayer2();
}