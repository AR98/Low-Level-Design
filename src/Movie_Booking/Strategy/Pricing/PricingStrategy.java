package Movie_Booking.Strategy.Pricing;

import Movie_Booking.Model.Enum.SeatType;

public interface PricingStrategy {
    double getPrice(SeatType type);
}
