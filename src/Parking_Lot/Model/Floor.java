package Parking_Lot.Model;

import Parking_Lot.Model.Enum.SpotType;
import Parking_Lot.Model.Enum.VehicleType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Floor {
    private int level;
    private final Map<Integer, ParkingSpot> spots = new HashMap<>();

    public Floor(int l){
        this.level = l;
    }

    public void addSpots(ParkingSpot spot){
        spots.put(spot.getId(), spot);
    }

    public int getLevel(){
        return  this.level;
    }

    public ParkingSpot findAvailableSpot(VehicleType vehicleType) {
        for (ParkingSpot spot : spots.values()) {
            if (spot.reserve(vehicleType)) {
                return spot;
            }
        }
        return null;
    }
}
