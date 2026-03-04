package Parking_Lot.Model;

import Parking_Lot.Model.Enum.VehicleType;

public class Car extends Vehicle {
    public Car(String licenceNumber){
        super(licenceNumber, VehicleType.CAR);
    }

}
