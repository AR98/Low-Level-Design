package Parking_Lot.Model;

import Parking_Lot.Model.Enum.VehicleType;

public abstract class Vehicle {
    private String licenceNumber;
    private VehicleType type;

    public Vehicle(String licenceNumber, VehicleType type){
            this.licenceNumber = licenceNumber;
            this.type = type;
    }

    public VehicleType getType() {
        return type;
    }
}
