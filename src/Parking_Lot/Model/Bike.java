package Parking_Lot.Model;

import Parking_Lot.Model.Enum.VehicleType;

public class Bike extends Vehicle{

    public Bike(String licenceNumber){
        super(licenceNumber,VehicleType.BIKE);
    }
}
