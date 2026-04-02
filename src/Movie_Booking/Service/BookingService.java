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

            if(locked.stream().anyMatch(ss-> ss.getStatus()!= SeatStatus.AVAILABLE)){
                System.out.println("Failed: Seats already booked.");
                return;
            }

            locked.forEach(s -> s.setStatus(SeatStatus.LOCKED));
            double total = locked.stream().mapToDouble(ss-> ss.getPrice()).sum();
            PaymentStrategy payment = PaymentFactory.getPaymentMethod(paymentType);
            if(payment.process(total)){
                locked.forEach(s -> s.setStatus(SeatStatus.BOOKED));
                System.out.println("Confirmed: " + show.movie.title + " | Total: ₹" + total);
            }else{
                locked.forEach(s-> s.setStatus(SeatStatus.AVAILABLE));
            }
        }finally {
            locked.forEach(ShowSeat::unLock);
        }
    }
}
