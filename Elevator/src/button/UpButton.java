package button;

import elevator.Direction;
import elevator.ElevatorSystem;
import elevator.State;
import elevator.Elevator;

public class UpButton extends SingleStateButton{
    public UpButton() {

    }

    @Override
    public Elevator press(ElevatorSystem elevatorSystem) {
        Elevator targetElevator = null;
        Elevator[] elevator = elevatorSystem.getElevatorList();
        for (Elevator elv : elevator) {
            if (elv.getCurrentDirection() == Direction.UP) {
                targetElevator = elv;
                return targetElevator;
            }
        }
        for (Elevator elv : elevator) {
            if (elv.getCurrentDirection() == Direction.IDLE) {
                targetElevator = elv;
                targetElevator.setCurrentDirection(Direction.UP);
                return targetElevator;
            }
        }
        elevator[0].setCurrentDirection(Direction.UP);
        return elevator[0];
    }
}
