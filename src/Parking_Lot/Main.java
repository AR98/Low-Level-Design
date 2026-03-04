package Parking_Lot;

import Parking_Lot.Factory.VehicleFactory;
import Parking_Lot.Model.*;
import Parking_Lot.Model.Enum.PaymentMode;
import Parking_Lot.Model.Enum.VehicleType;
import Parking_Lot.service.ParkingLotService;

public class Main {
    public static  void main(String[] args) throws InterruptedException {
        ParkingLotService service = ParkingLotService.getInstance();

        //1. setup
        Floor floor1 = new Floor(1);
        floor1.addSpots(new ParkingSpot(101, VehicleType.CAR));
        floor1.addSpots(new ParkingSpot(102, VehicleType.BIKE));
        service.addFloor(floor1);

        EntryGate entryGate  = new EntryGate("G-IN-1");
        ExitGate exitGate = new ExitGate("G-OUT-1");

        // 2. Simulation: CAR
        System.out.println("--- Processing CAR ---");
        Vehicle car = VehicleFactory.createVehicle("KA-001", VehicleType.CAR);
        Ticket t = entryGate.processEntry(car);
        if(t!=null) exitGate.processExit(t, PaymentMode.CARD);

        // 3. Simulation: BIKE
        System.out.println("\n--- Processing BIKE ---");
        Vehicle bike = VehicleFactory.createVehicle("KA-02-5678", VehicleType.BIKE);
        Ticket tb= entryGate.processEntry(bike);
        if (tb != null) exitGate.processExit(tb, PaymentMode.CASH);

    }
}
