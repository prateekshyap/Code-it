package parkingLot;

import vehicle.Vehicle;
import vehicle.VehicleType;

import ticket.Ticket;

public class ParkingSlot {
    boolean isAvailable;
    int slotTag;
    ParkingSlotType parkingSlotType;
    String vehicleCode;
    VehicleType vehicleType;

    public ParkingSlot(int slotTag, ParkingSlotType parkingSlotType) {
        this.isAvailable = true;
        this.slotTag = slotTag;
        this.parkingSlotType = parkingSlotType;
        this.vehicleCode = "";
        this.vehicleType = null;
    }

    public boolean parkVehicle(Vehicle vehicle, Ticket ticket) {
        this.isAvailable = false;
        this.vehicleCode = vehicle.getVehicleCode();
        this.vehicleType = vehicle.getVehicleType();
        ticket.addVehicleType(vehicle.getVehicleType());
        ticket.addVehicleCode(vehicle.getVehicleCode());
        return true;
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