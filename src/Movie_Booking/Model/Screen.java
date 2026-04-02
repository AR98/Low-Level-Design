package Movie_Booking.Model;

import java.util.List;

public class Screen {
    String id;
    List<Seat> physicalSeat;

    Screen(String id, List<Seat> seats){
        this.id = id;
        physicalSeat = seats;
    }

}
