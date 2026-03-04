package Parking_Lot.Model;

import Parking_Lot.Model.Enum.SpotType;

public class ParkingSpot {
    private final SpotType type;
    private final int id;
    private boolean isAvailable = false;

    ParkingSpot(int id, SpotType type){
        this.type = type;
        this.id = id;
    }

    public SpotType getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean status){
        this.isAvailable = status;
    }
}
