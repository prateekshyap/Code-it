package parkingLot;

import vehicle.Vehicle;
import vehicle.VehicleType;

import ticket.Ticket;

public class ParkingSlot {
    boolean isAvailable;
    int slotTag;
    ParkingSlotType parkingSlotType;
    Vehicle vehicle;
    String vehicleCode;
    VehicleType vehicleType;

    public ParkingSlot(int slotTag, ParkingSlotType parkingSlotType) {
        this.isAvailable = true;
        this.slotTag = slotTag;
        this.parkingSlotType = parkingSlotType;
        this.vehicle = null;
        this.vehicleCode = "";
        this.vehicleType = null;
    }

    public boolean parkVehicle(Vehicle vehicle, Ticket ticket) {
        this.isAvailable = false;
        this.vehicle = vehicle;
        this.vehicleCode = vehicle.getVehicleCode();
        this.vehicleType = vehicle.getVehicleType();
        ticket.addVehicleType(vehicle.getVehicleType());
        ticket.addVehicleCode(vehicle.getVehicleCode());
        return true;
    }

    public Vehicle removeVehicle(Ticket ticket) {
        this.isAvailable = true;
        Vehicle removedVehicle = this.vehicle;
        this.vehicle = null;
        this.vehicleType = null;
        this.vehicleCode = "";
        return removedVehicle;
    }

    public int getSlotTag () {
        return this.slotTag;
    }

    public ParkingSlotType getParkingSlotType() {
        return this.parkingSlotType;
    }

    @Override
    public String toString() {
        return "["+(isAvailable? (parkingSlotType == ParkingSlotType.SMALL ?
                                  "SM" : parkingSlotType == ParkingSlotType.COMPACT ?
                                         "CM" : "LG"
        )+slotTag+": Available" : vehicleType+":"+vehicleCode)+"]";
    }
}