package Movie_Booking.Service;

import Movie_Booking.Model.Enum.SeatStatus;
import Movie_Booking.Model.Show;
import Movie_Booking.Model.ShowSeat;
import Movie_Booking.Strategy.Payment.PaymentStrategy;
import Movie_Booking.factory.PaymentFactory;
import Parking_Lot.Model.Enum.PaymentMode;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BookingService {
    private static BookingService instance;
    private BookingService(){}

    public static synchronized BookingService getInstance(){
        if(instance==null){
            instance = new BookingService();
        }
        return instance;
    }

    public void book(Show show, List<String> seatIds, String paymentType){
        Collections.sort(seatIds);
        List<ShowSeat> selected = seatIds.stream().map(id-> show.showSeats.get(id)).toList();
        List<ShowSeat> locked = new ArrayList<>();

        try{
            for(ShowSeat ss: selected){
                if(ss.lock()) locked.add(ss);
                else System.out.println("Conflict: Seats currently being accessed.");
                return;
            }

            // 2. Check Business Availability (Fix: includes the 8-min expiry check)
            if (locked.stream().allMatch(ShowSeat::isActuallyAvailable)) {

                // 3. Set the 8-minute hold
                locked.forEach(s -> s.reserve(8));
                double total = locked.stream().mapToDouble(ShowSeat::getPrice).sum();

                // 4. Process Payment
                PaymentStrategy payment = PaymentFactory.getPaymentMethod(paymentType);
                if (payment.process(total)) {
                    locked.forEach(ShowSeat::confirm);
                    System.out.println("Success! Total: ₹" + total);
                } else {
                    // If payment fails, release the seats immediately
                    locked.forEach(ShowSeat::release);
                    System.out.println("Payment Failed. Seats released.");
                }
            } else {
                System.out.println("Failed: Some seats are currently held by others.");
            }
        } catch (Exception e) {
            System.out.println("System Error: " + e.getMessage());
        } finally {
            // 5. CRITICAL FIX: Release thread locks so other users can try.
            // This happens even if payment is still "pending" in the user's brain.
            locked.forEach(ShowSeat::unLock);
        }
    }
}
