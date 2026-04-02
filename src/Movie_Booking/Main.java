package Movie_Booking;

import Movie_Booking.Model.Enum.SeatType;
import Movie_Booking.Model.Movie;
import Movie_Booking.Model.Screen;
import Movie_Booking.Model.Seat;
import Movie_Booking.Model.Show;
import Movie_Booking.Service.BookingService;
import Movie_Booking.Service.ScreenScheduler;
import Movie_Booking.Strategy.Pricing.WeekEndPricing;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    public  static  void main(String[] args){
        System.out.println("--- Starting Movie Booking Simulation ---");

        // 1. Setup Infrastructure
        List<Seat> layout = Arrays.asList(
                new Seat("1A", SeatType.REGULAR),
                new Seat("5R", SeatType.RECLINER)
        );
        Screen sc1 = new Screen("SCREEN-01", layout);
        ScreenScheduler scheduler = new ScreenScheduler();

        // 2. Setup Movie & Show
        Movie movie = new Movie("Interstellar", 169);
        Show eveningShow = new Show(movie, sc1, LocalDateTime.now(), new WeekEndPricing());

        // 3. Schedule the Show
        if(scheduler.addShow(eveningShow)) {
            System.out.println("Show scheduled successfully for: " + movie.title);

            // 4. Process Booking
            System.out.println("Attempting to book seats 1A and 5R...");
            BookingService.getInstance().book(eveningShow, Arrays.asList("1A", "5R"), "UPI");
        } else {
            System.out.println("Failed to schedule show due to time conflict.");
        }

        System.out.println("--- Simulation Finished ---");
    }
}
