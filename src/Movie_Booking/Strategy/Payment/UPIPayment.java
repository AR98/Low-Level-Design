package Movie_Booking.Strategy.Payment;

public class UPIPayment implements  PaymentStrategy{
    @Override
    public boolean process(double amount) {
        System.out.println("Processing UPI Payment of ₹" + amount);
        return true;
    }
}
