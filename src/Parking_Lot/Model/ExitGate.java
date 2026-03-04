package Parking_Lot.Model;

import Parking_Lot.Model.Enum.GateType;
import Parking_Lot.Model.Enum.PaymentMode;
import Parking_Lot.service.ParkingLotService;

import java.time.LocalDateTime;

public class ExitGate extends Gate {

    public ExitGate(String id) {
        super(id);
    }

    public void processExit(Ticket ticket, PaymentMode paymentType) {
        if (ticket == null) {
            System.out.println("Invalid Ticket!");
            return;
        }

        System.out.println("Gate " + id + ": Processing exit for spot " + ticket.getSpot().getId());

        // Delegate to Service.
        // The Service will use PricingFactory and PaymentFactory internally.
        ParkingLotService.getInstance().exit(ticket, paymentType);

        System.out.println("Gate " + id + ": Payment processed. Thank you for parking with us!");
    }
}
