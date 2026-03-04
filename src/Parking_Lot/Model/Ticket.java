package Parking_Lot.Model;

import Parking_Lot.Model.Enum.SpotType;

import java.time.LocalDateTime;

public class Ticket {
    private final String id = "TKT-"+ System.currentTimeMillis();
    private final LocalDateTime entryTime = LocalDateTime.now();
    private int floorNumber;
    private ParkingSpot spot;
    private Vehicle vehicle;

    public Ticket(ParkingSpot spot, Vehicle v, int floorNumber){
        this.spot = spot;
        this.vehicle = v;
        this.floorNumber = floorNumber;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }


    public ParkingSpot getSpot() {
        return spot;
    }
}
