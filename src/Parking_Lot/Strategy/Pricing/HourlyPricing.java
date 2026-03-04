package Parking_Lot.Strategy.Pricing;

import Parking_Lot.Model.Enum.VehicleType;

import java.time.Duration;
import java.time.LocalDateTime;

public class HourlyPricing implements PricingStrategy {
    @Override
    public double calculatePrice(LocalDateTime s, LocalDateTime e, VehicleType type) {
        long hour = Math.max(1, Duration.between(s,e).toHours());
        double rate = switch (type){
            case BIKE -> 10.0;
            case TRUCK -> 40.0;
            case CAR -> 20.0;
        };

        return  hour * rate;
    }
}
