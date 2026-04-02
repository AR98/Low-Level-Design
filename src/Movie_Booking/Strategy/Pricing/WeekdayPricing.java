package Movie_Booking.Strategy.Pricing;

import Movie_Booking.Model.Enum.SeatType;

public class WeekdayPricing implements PricingStrategy {
    @Override
    public double getPrice(SeatType type) {
        return type == SeatType.RECLINER ? 400 : 200;
    }
}
