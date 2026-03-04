package Parking_Lot.service;

import Parking_Lot.Factory.paymentStrategyFactory;
import Parking_Lot.Model.Enum.PaymentMode;
import Parking_Lot.Model.Floor;
import Parking_Lot.Model.ParkingSpot;
import Parking_Lot.Model.Ticket;
import Parking_Lot.Model.Vehicle;
import Parking_Lot.Strategy.Pricing.HourlyPricing;
import Parking_Lot.Strategy.Pricing.PricingStrategy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ParkingLotService {
    private static ParkingLotService instance;
    private final List<Floor> floors = new ArrayList<>();
    private PricingStrategy pricingStrategy = new HourlyPricing();

    private ParkingLotService(){};

    public static synchronized ParkingLotService getInstance(){
        if(instance==null){
            instance = new ParkingLotService();
        }
        return instance;
    }

    public void addFloor(Floor floor){
        this.floors.add(floor);
    }

    // Entry gate logic
    public Ticket entry(Vehicle v){
        for(Floor f: floors){
            ParkingSpot spot = f.findAvailableSpot(v.getType());
            if(spot!=null) {
                spot.reserve();
                return new Ticket(spot, v, f.getLevel());

            }
        }
        System.out.println("No available spots for " + v.getType());
        return null;
    }

    // Exit Gate logic
    public void exit(Ticket t, PaymentMode pm){
        double amount = new HourlyPricing().calculatePrice(
                t.getEntryTime(),
                LocalDateTime.now(),
                t.getVehicle().getType()
        );

        paymentStrategyFactory.get(pm).Pay(amount);
        t.getSpot().vacate();
        System.out.println("Payment processed for " + t.getVehicle().getType());
    }

}
