package button;

import elevator.Elevator;
import elevator.ElevatorSystem;
import elevator.State;

public class ToggleButton implements OpButton{
    State id;

    public ToggleButton(State id) {
        this.id = id;
    }

    public Elevator press(ElevatorSystem elevatorSystem) {
        return null;
    }
}
