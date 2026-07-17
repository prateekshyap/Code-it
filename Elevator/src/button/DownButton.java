package button;

import elevator.Direction;
import elevator.ElevatorSystem;
import elevator.State;
import elevator.Elevator;

public class DownButton extends SingleStateButton{
    public DownButton() {

    }

    @Override
    public Elevator press(ElevatorSystem elevatorSystem) {
        Elevator targetElevator = null;
        Elevator[] elevator = elevatorSystem.getElevatorList();
        for (Elevator elv : elevator) {
            if (elv.getCurrentDirection() == Direction.DOWN) {
                targetElevator = elv;
                return targetElevator;
            }
        }
        for (Elevator elv : elevator) {
            if (elv.getCurrentDirection() == Direction.IDLE) {
                targetElevator = elv;
                targetElevator.setCurrentDirection(Direction.DOWN);
                return targetElevator;
            }
        }
        elevator[0].setCurrentDirection(Direction.DOWN);
        return elevator[0];
    }
}
