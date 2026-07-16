package parkingLot;

import vehicle.Vehicle;
import vehicle.VehicleType;

import ticket.Ticket;

public class ParkingLot {
    final int defaultLevelCount = 3;

    int levels;
    ParkingLevel[] parkingLot;
    int nextAvailableLevel;

    public ParkingLot () {
        this.levels = defaultLevelCount;
        this.parkingLot = new ParkingLevel[levels];
        for (int l = 0; l < levels; ++l) {
            this.parkingLot[l] = new ParkingLevel(l);
        }
        this.nextAvailableLevel = 0;
    }

    public ParkingLot (int levels) {
        this.levels = levels;
        this.parkingLot = new ParkingLevel[levels];
        for (int l = 0; l < levels; ++l) {
            this.parkingLot[l] = new ParkingLevel(l);
        }
        this.nextAvailableLevel = 0;
    }

    public int getLevels() {
        return this.levels;
    }

    public boolean parkVehicle(Vehicle vehicle, Ticket ticket) {
        boolean isParkingPossible = parkingLot[nextAvailableLevel].checkParkingPossibility(vehicle);
        boolean isParked = false;
        if (isParkingPossible) {
            this.nextAvailableLevel = parkingLot[nextAvailableLevel].parkVehicle(vehicle, ticket);
            ticket.addParkingLevel(parkingLot[nextAvailableLevel]);
            isParked = true;
        } else {
            for (int l = nextAvailableLevel+1; l < levels; ++l) {
                if (parkingLot[l].checkParkingPossibility(vehicle)) {
                    parkingLot[l].parkVehicle(vehicle, ticket);
                    ticket.addParkingLevel(parkingLot[l]);
                    isParked = true;
                    break;
                }
            }
        }
        return isParked;
    }

    public Vehicle removeVehicle(Ticket ticket) {
        int parkingLevel = ticket.getParkingLevel();
        return parkingLot[parkingLevel].removeVehicle(ticket);
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("=== Parking Lot with "+levels+" levels===");
        buffer.append("\n\n");
        for (int l = 0; l < levels; ++l) {
            buffer.append(parkingLot[l]);
            buffer.append("\n");
        }
        buffer.append("\n");
        return buffer.toString();
    }
}