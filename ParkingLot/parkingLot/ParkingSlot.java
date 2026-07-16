package parkingLot;

import vehicle.Vehicle;
import vehicle.VehicleType;

public class ParkingSlot {
    boolean isAvailable;
    ParkingSlotType parkingSlotType;
    String vehicleCode;
    VehicleType vehicleType;

    public ParkingSlot(ParkingSlotType parkingSlotType) {
        this.isAvailable = true;
        this.parkingSlotType = parkingSlotType;
        this.vehicleCode = "";
        this.vehicleType = null;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        this.isAvailable = false;
        this.vehicleCode = vehicle.getVehicleCode();
        this.vehicleType = vehicle.getVehicleType();
        return true;
    }

    @Override
    public String toString() {
        return "["+(isAvailable? "Status: Available" : vehicleType+":"+vehicleCode)+"]";
    }
}