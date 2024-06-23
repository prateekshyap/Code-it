package player;

public interface Player {
    public String getName();
    public int getHealth();
    public int getStrength();
    public int getAttack();
    public int getAttackCount();
    public int attack(int attackingDiceFaceValue);
    public void defend(int damage, int defendingDiceFaceValue);
    public void restoreStatus();
}