package ticket;

import parkingLot.ParkingSlot;
import parkingLot.ParkingLevel;
import parkingLot.ParkingSlotType;

import vehicle.Vehicle;
import vehicle.VehicleType;

public class Ticket {
    int parkingLevel;
    int parkingSlot;
    ParkingSlotType parkingSlotType;
    int timestamp;
    VehicleType vehicleType;
    String vehicleCode;

    public Ticket() {
        timestamp = -1;
    }

    public Ticket(int timestamp) {
        this.timestamp = timestamp;
    }

    public void addParkingLevel(ParkingLevel parkingLevel) {
        this.parkingLevel = parkingLevel.getLevelTag();
    }

    public void addParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot.getSlotTag();
        this.parkingSlotType = parkingSlot.getParkingSlotType();
    }

    public void addVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void addVehicleCode(String vehicleCode) {
        this.vehicleCode =vehicleCode;
    }

    public int getTimestamp() {
        return this.timestamp;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();

        buffer.append("---PARKING TICKET---\n");
        buffer.append("at time "+timestamp+"\n");
        buffer.append("for "+vehicleType+": "+vehicleCode+"\n");
        buffer.append("Parked at: B"+parkingLevel+"-"+
                (parkingSlotType == ParkingSlotType.SMALL ?
                        "SM" : parkingSlotType == ParkingSlotType.COMPACT ?
                        "CM" : "LG"
                        )+"-"+parkingSlot+"\n");

        return buffer.toString();
    }
}