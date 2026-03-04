package Parking_Lot.Strategy.Pricing;

import Parking_Lot.Model.Enum.VehicleType;

import java.time.LocalDateTime;

public interface PricingStrategy {
    public double calculatePrice(LocalDateTime s, LocalDateTime e, VehicleType type);
}
