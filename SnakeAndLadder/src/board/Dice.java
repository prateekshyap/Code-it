package board;

public class Dice {
    int faces;
    public Dice() {
        faces = 6;
    }
    public Dice(int faces) {
        this.faces = faces;
    }
    public int roll() {
        return 1 + (int)(Math.random() * ((faces - 1) + 1));
    }
}
