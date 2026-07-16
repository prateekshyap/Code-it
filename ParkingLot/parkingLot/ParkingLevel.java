package parkingLot;

import vehicle.VehicleType;
import vehicle.Vehicle;

public class ParkingLevel {
    final int defaultSlotCount = 10;

    int levelTag;
    int smallSlotCount, nextAvailableSmallSlot, availableSmallSlotCount;
    int compactSlotCount, nextAvailableCompactSlot, availableCompactSlotCount;
    int largeSlotCount, nextAvailableLargeSlot, availableLargeSlotCount;

    ParkingSlot[] smallSlotList, compactSlotList, largeSlotList;

    public ParkingLevel(int levelTag) {
        this.levelTag = levelTag;
        this.smallSlotCount = this.compactSlotCount = this.largeSlotCount = defaultSlotCount;
        this.availableSmallSlotCount = this.availableCompactSlotCount = this.availableLargeSlotCount = defaultSlotCount;
        this.nextAvailableSmallSlot = this.nextAvailableCompactSlot = this.nextAvailableLargeSlot = 0;
        this.smallSlotList = new ParkingSlot[smallSlotCount];
        this.compactSlotList = new ParkingSlot[compactSlotCount];
        this.largeSlotList = new ParkingSlot[largeSlotCount];
        for (int s = 0; s < smallSlotCount; ++s) {
            this.smallSlotList[s] = new ParkingSlot(ParkingSlotType.SMALL);
        }
        for (int c = 0; c < compactSlotCount; ++c) {
            this.compactSlotList[c] = new ParkingSlot(ParkingSlotType.COMPACT);
        }
        for (int l = 0; l < largeSlotCount; ++l) {
            this.largeSlotList[l] = new ParkingSlot(ParkingSlotType.LARGE);
        }
    }

    public ParkingLevel(int levelTag, int smallSlotCount, int compactSlotCount, int largeSlotCount) {
        this.levelTag = levelTag;
        this.smallSlotCount = smallSlotCount;
        this.availableSmallSlotCount = smallSlotCount;
        this.compactSlotCount = compactSlotCount;
        this.availableCompactSlotCount = compactSlotCount;
        this.largeSlotCount = largeSlotCount;
        this.availableLargeSlotCount = largeSlotCount;
        this.nextAvailableSmallSlot = this.nextAvailableCompactSlot = this.nextAvailableLargeSlot = 0;
        this.smallSlotList = new ParkingSlot[smallSlotCount];
        this.compactSlotList = new ParkingSlot[compactSlotCount];
        this.largeSlotList = new ParkingSlot[largeSlotCount];
        for (int s = 0; s < smallSlotCount; ++s) {
            this.smallSlotList[s] = new ParkingSlot(ParkingSlotType.SMALL);
        }
        for (int c = 0; c < compactSlotCount; ++c) {
            this.compactSlotList[c] = new ParkingSlot(ParkingSlotType.COMPACT);
        }
        for (int l = 0; l < largeSlotCount; ++l) {
            this.largeSlotList[l] = new ParkingSlot(ParkingSlotType.LARGE);
        }
    }

    public boolean checkParkingPossibility(Vehicle vehicle) {
        VehicleType vehicleType = vehicle.getVehicleType();
        if (vehicleType == VehicleType.BIKE) {
            if (availableLargeSlotCount == 0 && availableCompactSlotCount == 0 &&
                    availableSmallSlotCount == 0) return false;
            else return true;
        } else if (vehicleType == VehicleType.CAR) {
            if (availableCompactSlotCount == 0 && availableLargeSlotCount == 0)
                return false;
            else return true;
        } else if (vehicleType == VehicleType.BUS) {
            if (availableLargeSlotCount >= 3) return true;
            else return false;
        }
        return false;
    }

    public int parkVehicle(Vehicle vehicle) {
        VehicleType vehicleType = vehicle.getVehicleType();
        if (vehicleType == VehicleType.BIKE) {
            if (nextAvailableSmallSlot != -1) {
                // park in this slot
                smallSlotList[nextAvailableSmallSlot].parkVehicle(vehicle);
                nextAvailableSmallSlot =
                        nextAvailableSmallSlot+1 == smallSlotCount ? -1 : nextAvailableSmallSlot+1;
                --availableSmallSlotCount;
            } else if (nextAvailableCompactSlot != -1) {
                compactSlotList[nextAvailableCompactSlot].parkVehicle(vehicle);
                nextAvailableCompactSlot =
                        nextAvailableCompactSlot+1 == compactSlotCount ? -1 : nextAvailableCompactSlot+1;
                --availableCompactSlotCount;
            } else /*if (nextAvailableLargeSlot != -1)*/ {
                largeSlotList[nextAvailableLargeSlot].parkVehicle(vehicle);
                nextAvailableLargeSlot =
                        nextAvailableLargeSlot + 1 == largeSlotCount ? -1 : nextAvailableLargeSlot + 1;
                --availableLargeSlotCount;
            }
        }
        else if (vehicleType == VehicleType.CAR) {
            if (nextAvailableCompactSlot != -1) {
                compactSlotList[nextAvailableCompactSlot].parkVehicle(vehicle);
                nextAvailableCompactSlot =
                        nextAvailableCompactSlot+1 == compactSlotCount ? -1 : nextAvailableCompactSlot+1;
                --availableCompactSlotCount;
            } else /*if (nextAvailableLargeSlot != -1)*/ {
                largeSlotList[nextAvailableLargeSlot].parkVehicle(vehicle);
                nextAvailableLargeSlot =
                        nextAvailableLargeSlot + 1 == largeSlotCount ? -1 : nextAvailableLargeSlot + 1;
                --availableLargeSlotCount;
            }
        } else /*if (vehicleType == VehicleType.BUS)*/ {
            largeSlotList[nextAvailableLargeSlot].parkVehicle(vehicle);
            largeSlotList[nextAvailableLargeSlot+1].parkVehicle(vehicle);
            largeSlotList[nextAvailableLargeSlot+2].parkVehicle(vehicle);
            nextAvailableLargeSlot =
                    nextAvailableLargeSlot+3 == largeSlotCount ? -1 : nextAvailableLargeSlot+3;
            availableLargeSlotCount -= 3;
        }
        if (availableSmallSlotCount == 0 && availableCompactSlotCount == 0 && availableLargeSlotCount == 0)
            return levelTag+1;
        else
            return levelTag;
//        return -1;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("---Level "+levelTag+"---");
        buffer.append("\n");
        buffer.append("\n");
        for (int s = 0; s < smallSlotCount; ++s) {
            buffer.append(smallSlotList[s]);
        }
        buffer.append("\n");
        for (int s = 0; s < compactSlotCount; ++s) {
            buffer.append(compactSlotList[s]);
        }
        buffer.append("\n");
        for (int s = 0; s < largeSlotCount; ++s) {
            buffer.append(largeSlotList[s]);
        }
        buffer.append("\n");
        return buffer.toString();
    }
}