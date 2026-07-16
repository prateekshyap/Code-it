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
    int entryTime;
    int exitTime;
    VehicleType vehicleType;
    String vehicleCode;

    public Ticket() {
        entryTime = -1;
        exitTime = -1;
    }

    public Ticket(int entryTime) {
        this.entryTime = entryTime;
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
        this.vehicleCode = vehicleCode;
    }

    public int getParkingLevel() {
        return this.parkingLevel;
    }

    public int getParkingSlot() {
        return this.parkingSlot;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public ParkingSlotType getParkingSlotType() {
        return parkingSlotType;
    }

    public int getEntryTime() {
        return this.entryTime;
    }

    public int getExitTime() {
        return this.exitTime;
    }

    public void setExitTime(int time) {
        this.exitTime = time;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();

        buffer.append("---PARKING TICKET---\n");
        buffer.append("at time "+entryTime+"\n");
        buffer.append("for "+vehicleType+": "+vehicleCode+"\n");
        buffer.append("Parked at: B"+parkingLevel+"-"+
                (parkingSlotType == ParkingSlotType.SMALL ?
                        "SM" : parkingSlotType == ParkingSlotType.COMPACT ?
                        "CM" : "LG"
                        )+"-"+parkingSlot+"\n");

        return buffer.toString();
    }
}