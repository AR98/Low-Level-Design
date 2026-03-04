package Parking_Lot.Model;

import Parking_Lot.Model.Enum.VehicleType;

public class Truck extends  Vehicle{
    public Truck(String licenceNumber){
        super(licenceNumber, VehicleType.TRUCK);
    }
}
