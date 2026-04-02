package Movie_Booking.Model;

import Movie_Booking.Model.Enum.SeatType;

public class Seat {
    String id;
    SeatType type;

    public Seat(String id, SeatType type){
        this.id = id;
        this.type = type;
    }
}
