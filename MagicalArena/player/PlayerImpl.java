package player;

public class PlayerImpl implements Player{
    private String name;
    private int health;
    private int strength;
    private int attack;
    private int attackCount;
    private int health_HISTORY;

    public PlayerImpl(String name, int health, int strength, int attack) throws Exception {
        if (health <= 0){
            throw new InvalidHealthException("Health value must be greater than 0.");
        }
        if (strength <= 0){
            throw new InvalidStrengthException("Strength value must be greater than 0.");
        }
        if (attack <= 0){
            throw new InvalidAttackException("Attack value must be greater than 0.");
        }
        this.name = name;
        this.health = this.health_HISTORY = health;
        this.strength = strength;
        this.attack = attack;
        this.attackCount = 0;
    }

    @Override
    public int attack(int attackingDiceFaceValue) {
        ++this.attackCount;
        return attackingDiceFaceValue*this.attack; // return the damage value
    }

    @Override
    public void defend(int damage, int defendingDiceFaceValue) {
        this.health -= Math.max(0,damage-(defendingDiceFaceValue*this.strength)); // reduce the health if damage exceeds defense
    }

    @Override
    public void restoreStatus() {
        this.health = this.health_HISTORY;
        this.attackCount = 0;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Player ");
        buffer.append(this.name);
        buffer.append("\nHealth: ");
        buffer.append(this.health);
        buffer.append(", Strength: ");
        buffer.append(this.strength);
        buffer.append(", Attack: ");
        buffer.append(this.attack);
        buffer.append("\n");
        return buffer.toString();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }

    @Override
    public int getAttack() {
        return this.attack;
    }

    @Override
    public int getAttackCount() {
        return this.attackCount;
    }
}

class InvalidHealthException extends Exception {
    public InvalidHealthException(String str) {
        super(str);
    }
}
class InvalidStrengthException extends Exception {
    public InvalidStrengthException(String str) {
        super(str);
    }
}
class InvalidAttackException extends Exception {
    public InvalidAttackException(String str) {
        super(str);
    }
}