package floor;

import elevator.State;

import button.OpButton;
import button.SingleStateButton;
import button.UpButton;
import button.DownButton;

public class Floor {
    int id;
    OpButton upButton, downButton;

    public Floor(int id) {
        this.id = id;
        this.upButton = new UpButton();
        this.downButton = new DownButton();
    }

    public int getId() { return this.id; }

    public OpButton getUpButton() { return this.upButton; }

    public OpButton getDownButton() { return this.downButton; }
}
