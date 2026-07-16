package paymentService;

import vehicle.VehicleType;

import ticket.Ticket;

public class PaymentService {
    public static int processPayment(Ticket ticket) {
        VehicleType vehicleType = ticket.getVehicleType();
        int timeDuration = ticket.getExitTime()-ticket.getEntryTime();
        return timeDuration * (
                vehicleType == VehicleType.BIKE ? 10 :
                        vehicleType == VehicleType.CAR ? 20 :
                50);
    }
}