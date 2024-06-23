package player;

import player.Player;
import player.PlayerImpl;

class TestPlayerImpl {
    public static void main(String[] args) throws Exception {
        TestPlayerImpl test = new TestPlayerImpl();
        test.testCreatePlayer("Test",100,5,0);
        test.testCreatePlayer("Test",100,-5,10);
        test.testCreatePlayer("Test",-100,60,20);
        Player player = null;
        //attack with dice face value 1
        try {
        player = new PlayerImpl("Test",100,10,5);
        int diceFaceValue = 1;
        test.testAttack(player,diceFaceValue);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        //attack with dice face value 6
        try {
        player = new PlayerImpl("Test",100,10,5);
        int diceFaceValue = 6;
        test.testAttack(player,diceFaceValue);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        //defend with damage more than maximum dice value multiplied by strength
        try {        
        player = new PlayerImpl("Test",100,10,5);
        int damage = 70;
        int diceFaceValue = 6;
        test.testDefendWithMoreDamage(player,damage,diceFaceValue);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        //defend with damage less than minimum dice value multiplied by strength
        try {        
        player = new PlayerImpl("Test",100,10,5);
        int damage = 9;
        int diceFaceValue = 1;
        test.testDefendWithLessDamage(player,damage,diceFaceValue);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        //restoring health and attack count after a match
        test.testRestoreStatus(player);
    }
    void testCreatePlayer(String name, int health, int strength, int attack) {
        try {
        Player player = new PlayerImpl(name, health, strength, attack);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    void testAttack(Player player, int diceFaceValue) {
        int damage = player.attack(diceFaceValue);
        if (damage == player.getAttack()*diceFaceValue) {
            System.out.println("Passed.");
        }
        else {
            System.out.println("Damage exceeded expected value.");
        }
    }
    void testDefendWithMoreDamage(Player player, int damage, int diceFaceValue) {
        int healthBeforeDefense = player.getHealth();
        player.defend(damage, diceFaceValue);
        if (healthBeforeDefense-(damage-(player.getStrength()*diceFaceValue)) == player.getHealth()) {
            System.out.println("Passed.");
        }
        else {
            System.out.println("Health exceeded expected value.");
        }
    }
    void testDefendWithLessDamage(Player player, int damage, int diceFaceValue) {
        int healthBeforeDefense = player.getHealth();
        player.defend(damage, diceFaceValue);
        if (healthBeforeDefense == player.getHealth()) {
            System.out.println("Passed.");
        }
        else {
            System.out.println("Health exceeded expected value.");
        }
    }
    void testRestoreStatus(Player player) {
        player.restoreStatus();
        int health = player.getHealth();
        if (health == 100) {
            System.out.println("Passed.");
        }
        else {
            System.out.println("Restore failed.");
        }
    }
}