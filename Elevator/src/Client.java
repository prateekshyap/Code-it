import button.DigitButton;
import elevator.*;

import floor.FloorSystem;
import floor.Floor;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        FloorSystem floorSystem = new FloorSystem();
        ElevatorSystem elevatorSystem = new ElevatorSystem(floorSystem.getNumFloor());

        Elevator elevator;

        // these operations are carried outside the elevators, on the floor
        Floor floor = floorSystem.getFloor(10);
        elevator = floor.getUpButton().press(elevatorSystem);
        elevator.move(floor);
        System.out.println("Taking elevator " + elevator.getId());

        //after entering into the lift
        DigitButton[] digitButtons = elevator.getDigit();
        digitButtons[15].press();
        elevator.move(floorSystem.getFloor(15));
        System.out.println("Moved to floor 15");

        floor = floorSystem.getFloor(20);
        elevator = floor.getDownButton().press(elevatorSystem);
        elevator.move(floor);
        System.out.println("Taking elevator " + elevator.getId());

        digitButtons = elevator.getDigit();
        digitButtons[15].press();
        elevator.move(floorSystem.getFloor(15));
        System.out.println("Moved to floor 15");
    }
}
