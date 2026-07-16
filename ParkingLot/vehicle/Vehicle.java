package vehicle;

import ticket.Ticket;

enum VehicleSize {
    SMALL, MEDIUM, LARGE
}

public class Vehicle {
    VehicleType vehicleType;
    VehicleSize vehicleSize;
    String vehicleCode;
    Ticket ticket;

    public Vehicle(VehicleType type, String vehicleCode) {
        this.vehicleType = type;
        if (type == VehicleType.BIKE)
            this.vehicleSize = VehicleSize.SMALL;
        else if (type == VehicleType.CAR)
            this.vehicleSize = VehicleSize.MEDIUM;
        else if (type == VehicleType.BUS)
            this.vehicleSize = VehicleSize.LARGE;
        this.vehicleCode = vehicleCode;
        this.ticket = null;
    }

    Vehicle(VehicleType type, VehicleSize size, String vehicleCode) {
        this.vehicleType = type;
        this.vehicleSize = size;
        this.vehicleCode = vehicleCode;
        this.ticket = null;
    }

    public VehicleType getVehicleType() {
        return this.vehicleType;
    }

    public VehicleSize getVehicleSize() {
        return this.vehicleSize;
    }

    public String getVehicleCode() {
        return this.vehicleCode;
    }

    public void giveTicket(Ticket ticket) { this.ticket = ticket; }

    public Ticket getTicket() { return this.ticket; }

    @Override
    public String toString() {
        return "["+this.vehicleType+":"+this.vehicleCode+"]";
    }
}