package Parking_Lot.Model;

import Parking_Lot.Model.Enum.GateType;
import Parking_Lot.service.ParkingLotService;

import java.time.LocalDateTime;

public class EntryGate extends Gate {

    public EntryGate(String id) {
        super(id);
    }

    public Ticket processEntry(Vehicle vehicle) {
        System.out.println("Gate " + id + ": Processing entry for vehicle " + vehicle.getType());

        // Delegate to Service to find spot and create ticket
        Ticket ticket = ParkingLotService.getInstance().entry(vehicle);

        if (ticket == null) {
            System.out.println("Gate " + id + ": Entry Denied. Parking Lot Full!");
        } else {
            System.out.println("Gate " + id + ": Entry Successful. Ticket issued for Spot: " + ticket.getSpot().getId());
        }

        return ticket;
    }
}
