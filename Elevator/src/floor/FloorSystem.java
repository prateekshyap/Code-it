package floor;

import button.SingleStateButton;
import elevator.State;

public class FloorSystem {
    final int defaultNumFloor = 25;
    Floor[] floor;

    public FloorSystem() {
        this.floor = new Floor[defaultNumFloor];
        floor = new Floor[defaultNumFloor];
        for (int f = 0; f < floor.length; ++f) {
            floor[f] = new Floor(f);
        }
    }

    public FloorSystem(int numFloor) {
        this.floor = new Floor[numFloor];
        floor = new Floor[defaultNumFloor];
        for (int f = 0; f < floor.length; ++f) {
            floor[f] = new Floor(f);
        }
    }

    public Floor getFloor(int floorId) {
        return floorId < floor.length ? this.floor[floorId] : null;
    }

    public int getNumFloor() {
        return this.floor.length;
    }
}
