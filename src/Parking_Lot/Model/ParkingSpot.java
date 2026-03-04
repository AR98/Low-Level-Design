package Parking_Lot.Model;

import Parking_Lot.Model.Enum.SpotType;
import Parking_Lot.Model.Enum.VehicleType;

public class ParkingSpot {
    private final VehicleType type;
    private final int id;
    private boolean occupied = false;

    public ParkingSpot(int id, VehicleType type){
        this.type = type;
        this.id = id;
    }

    public void vacate() {
        occupied = false;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public VehicleType getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public void reserve(){
        occupied = true;
    }
}
