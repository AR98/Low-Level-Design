package Movie_Booking.Strategy.Pricing;

import Movie_Booking.Model.Enum.SeatType;

public class WeekEndPricing implements PricingStrategy {
    @Override
    public double getPrice(SeatType type) {
        return type == SeatType.RECLINER ? 600 : 400;
    }
}
