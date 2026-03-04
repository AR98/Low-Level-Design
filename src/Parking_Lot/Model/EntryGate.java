package Parking_Lot.Gate;

import Parking_Lot.Model.Enum.VehicleType;
import Parking_Lot.Model.Ticket;
import Parking_Lot.Model.Vehicle;

public class EntryGate extends  Gate{

    public EntryGate(String id){
        super(id);
    }

    public Ticket processEntry(Vehicle v){
        System.out.println("\n[GATE-" + id + "] Vehicle entering...");
        return null;
    }
}
