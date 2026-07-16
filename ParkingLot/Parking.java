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

public class Parking {
    public static void main(String[] args) throws IOException {
        // build the parking lot
        ParkingLot parkingLot = new ParkingLot();
        System.out.println(parkingLot);

        Vehicle vehicle = new Vehicle(VehicleType.BIKE, "OD 14B 2279");
        boolean isVehicleParked = parkingLot.parkVehicle(vehicle);
        System.out.println(vehicle.getVehicleCode()+ (isVehicleParked?" parked.":" not parked."));
        System.out.println(parkingLot);

        vehicle = new Vehicle(VehicleType.CAR, "JH 01K 1092");
        isVehicleParked = parkingLot.parkVehicle(vehicle);
        System.out.println(vehicle.getVehicleCode()+ (isVehicleParked?" parked.":" not parked."));
        System.out.println(parkingLot);

        vehicle = new Vehicle(VehicleType.BUS, "KA 19E 2893");
        isVehicleParked = parkingLot.parkVehicle(vehicle);
        System.out.println(vehicle.getVehicleCode()+ (isVehicleParked?" parked.":" not parked."));
        System.out.println(parkingLot);

        vehicle = new Vehicle(VehicleType.BUS, "KA 19E 2894");
        isVehicleParked = parkingLot.parkVehicle(vehicle);
        System.out.println(vehicle.getVehicleCode()+ (isVehicleParked?" parked.":" not parked."));
        System.out.println(parkingLot);

        vehicle = new Vehicle(VehicleType.BUS, "KA 19E 2895");
        isVehicleParked = parkingLot.parkVehicle(vehicle);
        System.out.println(vehicle.getVehicleCode()+ (isVehicleParked?" parked.":" not parked."));
        System.out.println(parkingLot);

        vehicle = new Vehicle(VehicleType.BUS, "KA 19E 2896");
        isVehicleParked = parkingLot.parkVehicle(vehicle);
        System.out.println(vehicle.getVehicleCode()+ (isVehicleParked?" parked.":" not parked."));
        System.out.println(parkingLot);

        vehicle = new Vehicle(VehicleType.BUS, "KA 19E 2897");
        isVehicleParked = parkingLot.parkVehicle(vehicle);
        System.out.println(vehicle.getVehicleCode()+ (isVehicleParked?" parked.":" not parked."));
        System.out.println(parkingLot);

        vehicle = new Vehicle(VehicleType.BUS, "KA 19E 2898");
        isVehicleParked = parkingLot.parkVehicle(vehicle);
        System.out.println(vehicle.getVehicleCode()+ (isVehicleParked?" parked.":" not parked."));
        System.out.println(parkingLot);

        vehicle = new Vehicle(VehicleType.BUS, "KA 19E 2899");
        isVehicleParked = parkingLot.parkVehicle(vehicle);
        System.out.println(vehicle.getVehicleCode()+ (isVehicleParked?" parked.":" not parked."));
        System.out.println(parkingLot);

        vehicle = new Vehicle(VehicleType.BUS, "KA 19E 2900");
        isVehicleParked = parkingLot.parkVehicle(vehicle);
        System.out.println(vehicle.getVehicleCode()+ (isVehicleParked?" parked.":" not parked."));
        System.out.println(parkingLot);

        vehicle = new Vehicle(VehicleType.BUS, "KA 19E 2901");
        isVehicleParked = parkingLot.parkVehicle(vehicle);
        System.out.println(vehicle.getVehicleCode()+ (isVehicleParked?" parked.":" not parked."));
        System.out.println(parkingLot);

        vehicle = new Vehicle(VehicleType.BUS, "KA 19E 2902");
        isVehicleParked = parkingLot.parkVehicle(vehicle);
        System.out.println(vehicle.getVehicleCode()+ (isVehicleParked?" parked.":" not parked."));
        System.out.println(parkingLot);


    }
}