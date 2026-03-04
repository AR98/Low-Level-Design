package Parking_Lot.Strategy.Payment;

public class CardPayment implements PaymentStrategy{
    @Override
    public void Pay(double amount) {
        System.out.println("Paying via Card Payment");
    }
}
