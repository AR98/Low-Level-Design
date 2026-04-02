package Movie_Booking.Strategy.Payment;

import Parking_Lot.Model.Enum.PaymentMode;

public interface PaymentStrategy {
    boolean process(double amount);

}
