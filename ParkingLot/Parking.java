import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

import vehicle.Vehicle;
import vehicle.VehicleType;

import parkingLot.ParkingSlot;
import parkingLot.ParkingLevel;
import parkingLot.ParkingLot;

import ticket.Ticket;

import paymentService.PaymentService;

public class Parking {
    public static void main(String[] args) throws IOException {
        // build the parking lot
        ParkingLot parkingLot = new ParkingLot();
        System.out.println(parkingLot);

        int timeCounter = 0;
        Ticket parkingTicket = null;

        Vehicle[] vehicle = new Vehicle[12];

        vehicle[0] = new Vehicle(VehicleType.BIKE, "OD 14B 2279");
        parkingTicket = new Ticket(timeCounter++);
        boolean isVehicleParked = parkingLot.parkVehicle(vehicle[0], parkingTicket);
        vehicle[0].giveTicket(parkingTicket);
        System.out.println(vehicle[0].getVehicleCode()+ (isVehicleParked? "parked.":" not parked."));
        if (isVehicleParked) {
            System.out.println(parkingTicket);
                System.out.println(parkingLot);
        }

        vehicle[1] = new Vehicle(VehicleType.CAR, "JH 01K 1092");
        parkingTicket = new Ticket(timeCounter++);
        isVehicleParked = parkingLot.parkVehicle(vehicle[1], parkingTicket);
        vehicle[1].giveTicket(parkingTicket);
        System.out.println(vehicle[1].getVehicleCode()+ (isVehicleParked?" parked.":" not parked."));
        if (isVehicleParked) {
            System.out.println(parkingTicket);
                System.out.println(parkingLot);
        }

        vehicle[2] = new Vehicle(VehicleType.BUS, "KA 19E 2893");
        parkingTicket = new Ticket(timeCounter++);
        isVehicleParked = parkingLot.parkVehicle(vehicle[2], parkingTicket);
        vehicle[2].giveTicket(parkingTicket);
        System.out.println(vehicle[2].getVehicleCode()+ (isVehicleParked?" parked.":" not parked."));
        if (isVehicleParked) {
            System.out.println(parkingTicket);
                System.out.println(parkingLot);
        }

        vehicle[3] = new Vehicle(VehicleType.BUS, "KA 19E 2894");
        parkingTicket = new Ticket(timeCounter++);
        isVehicleParked = parkingLot.parkVehicle(vehicle[3], parkingTicket);
        vehicle[3].giveTicket(parkingTicket);
        System.out.println(vehicle[3].getVehicleCode()+ (isVehicleParked?" parked.":" not parked."));
        if (isVehicleParked) {
            System.out.println(parkingTicket);
                System.out.println(parkingLot);
        }

        vehicle[4] = new Vehicle(VehicleType.BUS, "KA 19E 2895");
        parkingTicket = new Ticket(timeCounter++);
        isVehicleParked = parkingLot.parkVehicle(vehicle[4], parkingTicket);
        vehicle[4].giveTicket(parkingTicket);
        System.out.println(vehicle[4].getVehicleCode()+ (isVehicleParked?" parked.":" not parked."));
        if (isVehicleParked) {
            System.out.println(parkingTicket);
                System.out.println(parkingLot);
        }

        vehicle[5] = new Vehicle(VehicleType.BUS, "KA 19E 2896");
        parkingTicket = new Ticket(timeCounter++);
        isVehicleParked = parkingLot.parkVehicle(vehicle[5], parkingTicket);
        vehicle[5].giveTicket(parkingTicket);
        System.out.println(vehicle[5].getVehicleCode()+ (isVehicleParked?" parked.":" not parked."));
        if (isVehicleParked) {
            System.out.println(parkingTicket);
                System.out.println(parkingLot);
        }

        vehicle[6] = new Vehicle(VehicleType.BUS, "KA 19E 2897");
        parkingTicket = new Ticket(timeCounter++);
        isVehicleParked = parkingLot.parkVehicle(vehicle[6], parkingTicket);
        vehicle[6].giveTicket(parkingTicket);
        System.out.println(vehicle[6].getVehicleCode()+ (isVehicleParked?" parked." : " not parked."));
        if (isVehicleParked) {
            System.out.println(parkingTicket);
                System.out.println(parkingLot);
        }

        vehicle[7] = new Vehicle(VehicleType.BUS, "KA 19E 2898");
        parkingTicket = new Ticket(timeCounter++);
        isVehicleParked = parkingLot.parkVehicle(vehicle[7], parkingTicket);
        vehicle[7].giveTicket(parkingTicket);
        System.out.println(vehicle[7].getVehicleCode()+ (isVehicleParked?" parked.":" not parked."));
        if (isVehicleParked) {
            System.out.println(parkingTicket);
                System.out.println(parkingLot);
        }

        vehicle[8] = new Vehicle(VehicleType.BUS, "KA 19E 2899");
        parkingTicket = new Ticket(timeCounter++);
        isVehicleParked = parkingLot.parkVehicle(vehicle[8], parkingTicket);
        vehicle[8].giveTicket(parkingTicket);
        System.out.println(vehicle[8].getVehicleCode()+ (isVehicleParked?" parked." : " not parked."));
        if (isVehicleParked) {
            System.out.println(parkingTicket);
            System.out.println(parkingLot);
        }

        vehicle[9] = new Vehicle(VehicleType.BUS, "KA 19E 2900");
        parkingTicket = new Ticket(timeCounter++);
        isVehicleParked = parkingLot.parkVehicle(vehicle[9], parkingTicket);
        vehicle[9].giveTicket(parkingTicket);
        System.out.println(vehicle[9].getVehicleCode()+ (isVehicleParked?" parked.":" not parked."));
        if (isVehicleParked) {
            System.out.println(parkingTicket);
                System.out.println(parkingLot);
        }

        vehicle[10] = new Vehicle(VehicleType.BUS, "KA 19E 2901");
        parkingTicket = new Ticket(timeCounter++);
        isVehicleParked = parkingLot.parkVehicle(vehicle[10], parkingTicket);
        vehicle[10].giveTicket(parkingTicket);
        System.out.println(vehicle[10].getVehicleCode()+ (isVehicleParked ? " parked." : " not parked."));
        if (isVehicleParked) {
            System.out.println(parkingTicket);
            System.out.println(parkingLot);
        }

        vehicle[11] = new Vehicle(VehicleType.BUS, "KA 19E 2902");
        parkingTicket = new Ticket(timeCounter++);
        isVehicleParked = parkingLot.parkVehicle(vehicle[11], parkingTicket);
        if (isVehicleParked) {
            vehicle[11].giveTicket(parkingTicket);
        }
        System.out.println(vehicle[11].getVehicleCode()+ (isVehicleParked ? " parked." : " not parked."));
        if (isVehicleParked) {
            System.out.println(parkingTicket);
            System.out.println(parkingLot);
        }

        //start unparking
        parkingTicket = vehicle[4].getTicket();
        if (parkingTicket != null) {
            parkingTicket.setExitTime(timeCounter++);
            Vehicle removedVehicle = parkingLot.removeVehicle(parkingTicket);
            System.out.println("Target vehicle:");
            System.out.println(vehicle[4]);
            System.out.println("Removed vehicle:");
            System.out.println(removedVehicle);
            int fees = PaymentService.processPayment(parkingTicket);
            System.out.println(fees);
            System.out.println(parkingLot);
        }
    }
}