package Parking_Lot.Model;

import Parking_Lot.Model.Enum.SpotType;

import java.time.LocalDateTime;

public class Ticket {
    private final String id = "TKT-"+ System.currentTimeMillis();
    private final LocalDateTime entryTime = LocalDateTime.now();
    private SpotType type;
    private Vehicle vehicle;

    public Ticket(SpotType type, Vehicle v){
        this.type = type;
        this.vehicle = v;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public SpotType getType() {
        return type;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
