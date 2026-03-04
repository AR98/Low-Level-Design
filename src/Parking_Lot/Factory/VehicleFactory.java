package Parking_Lot.Factory;

import Parking_Lot.Model.Bike;
import Parking_Lot.Model.Car;
import Parking_Lot.Model.Enum.VehicleType;
import Parking_Lot.Model.Truck;
import Parking_Lot.Model.Vehicle;

import static Parking_Lot.Model.Enum.VehicleType.BIKE;
import static Parking_Lot.Model.Enum.VehicleType.CAR;

public class VehicleFactory {
    public static Vehicle createVehicle(String licenceNumber, VehicleType type){
        return switch (type) {
            case CAR -> new Car(licenceNumber);
            case BIKE -> new Bike(licenceNumber);
            case TRUCK -> new Truck(licenceNumber);
        };
    }
}
