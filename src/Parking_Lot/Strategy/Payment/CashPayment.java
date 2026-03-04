package Parking_Lot.Strategy.Payment;

public class CashPayment implements  PaymentStrategy{
    @Override
    public void Pay(double amount) {
        System.out.println("Paying via Cash Payment");
    }
}
