package Movie_Booking.Model;

import java.util.List;

public class Screen {
    public String id;
    List<Seat> physicalSeat;

    public Screen(String id, List<Seat> seats){
        this.id = id;
        physicalSeat = seats;
    }

}
