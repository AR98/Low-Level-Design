package Movie_Booking.factory;

import Movie_Booking.Strategy.Payment.CardPayment;
import Movie_Booking.Strategy.Payment.PaymentStrategy;
import Movie_Booking.Strategy.Payment.UPIPayment;
import Parking_Lot.Model.Enum.PaymentMode;

public class PaymentFactory {
    public static PaymentStrategy getPaymentMethod(PaymentMode mode){
        if(mode.equals(PaymentMode.UPI)) return new UPIPayment();
        else if(mode.equals(PaymentMode.CARD)) return new CardPayment();
        throw new  IllegalArgumentException("Unknown Payment Method");
    }
}
