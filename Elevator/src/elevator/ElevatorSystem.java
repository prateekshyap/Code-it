package elevator;

import button.OpButton;
import floor.Floor;

public class ElevatorSystem {
    final int defaultNumElevator = 6;
    final int defaultNumFloor = 25;

    Elevator[] elevator;

    public ElevatorSystem(int numFloor) {
        elevator = new Elevator[defaultNumElevator];
        for (int e = 0; e < elevator.length; ++e) {
            elevator[e] = new Elevator(e, numFloor);
        }
    }

    public ElevatorSystem(int numElevator, int numFloor) {
        elevator = new Elevator[numElevator];
        for (int e = 0; e < elevator.length; ++e) {
            elevator[e] = new Elevator(e, numFloor);
        }
    }

    public Elevator[] getElevatorList() { return this.elevator; }

//    public Elevator request(OpButton opButton) {
//
//    }
//
//    public Elevator request(Direction targetDirection, int targetFloor) {
//
//    }


}
