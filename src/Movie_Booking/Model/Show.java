package Movie_Booking.Model;

import Movie_Booking.Strategy.Pricing.PricingStrategy;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Show {
 public Movie movie;
 public Screen screen;
 public LocalDateTime startTime, endTime;
 public Map<String, ShowSeat> showSeats = new HashMap<>();
 public Show(Movie movie, Screen screen, LocalDateTime start, PricingStrategy pricing){
     this.movie = movie;
     this.screen = screen;
     this.startTime = start;
     this.endTime = start.plusMinutes(movie.durationMins+30);
     for(Seat s: screen.physicalSeat){
         showSeats.put(s.id, new ShowSeat(s, pricing.getPrice(s.type)));
     }
 }
}
