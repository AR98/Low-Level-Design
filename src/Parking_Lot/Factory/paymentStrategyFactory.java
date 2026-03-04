package Parking_Lot.Factory;

import Parking_Lot.Model.Enum.PaymentMode;
import Parking_Lot.Strategy.Payment.CardPayment;
import Parking_Lot.Strategy.Payment.CashPayment;
import Parking_Lot.Strategy.Payment.PaymentStrategy;

public class paymentStrategyFactory {
    public static PaymentStrategy get(PaymentMode mode){
        return switch (mode){
            case CASH -> new CashPayment();
            case CARD -> new CardPayment();
            default -> null;
        };
    }
}
