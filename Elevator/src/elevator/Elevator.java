package elevator;

import button.DigitButton;
import button.OpButton;
import button.SingleStateButton;
import button.OpenButton;
import button.CloseButton;
import button.ToggleButton;

import floor.Floor;

public class Elevator {
    int id;
    DigitButton[] digit;
    OpButton doorClose, doorOpen, emergency, fanToggle;
    Direction currentDirection;
    Floor currentFloor;

    public Elevator(int id, int numFloor) {
        this.id = id;

        digit = new DigitButton[numFloor];
        for (int f = 0; f < numFloor; ++f) {
            digit[f] = new DigitButton(f);
        }

        doorClose = new CloseButton();
        doorOpen = new OpenButton();

        fanToggle = new ToggleButton(State.CLOSE);

        emergency = new SingleStateButton();

        currentDirection = Direction.IDLE;

        currentFloor = null;
    }

    public int getId() { return this.id; }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public Floor getCurrentFloor() {
        return this.currentFloor;
    }

    public DigitButton[] getDigit() { return this.digit; }

    public void setCurrentDirection(Direction direction) {
        this.currentDirection = direction;
    }

    public void move(Floor floor) throws InterruptedException {
        Thread.sleep(10000);
        this.currentFloor = floor;
    }
}
