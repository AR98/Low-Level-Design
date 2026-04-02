package Movie_Booking.Strategy.Payment;

public class CardPayment implements PaymentStrategy{
    @Override
    public boolean process(double amount) {
        System.out.println("Processing Card Payment of ₹" + amount);
        return true;
    }
}
