package button;

import elevator.Elevator;
import elevator.ElevatorSystem;

public interface OpButton extends Button {
    public Elevator press(ElevatorSystem elevatorSystem);
}
