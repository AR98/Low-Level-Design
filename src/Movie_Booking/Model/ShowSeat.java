package Movie_Booking.Model;

import Movie_Booking.Model.Enum.SeatStatus;

import java.util.concurrent.locks.ReentrantLock;

public class ShowSeat {
    private Seat seat;
    private SeatStatus status = SeatStatus.AVAILABLE;
    private  final double price;
    private final ReentrantLock lock = new ReentrantLock();

    ShowSeat(Seat seat, double price){
        this.seat = seat;
        this.price = price;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public double getPrice() {
        return price;
    }

    public String getSeatId(){ return seat.id;}

    public  boolean lock(){ return lock.tryLock();}
    public void unLock(){ lock.unlock();}
    public void reserve(){ status = SeatStatus.LOCKED;}
    public void confirm(){ status = SeatStatus.BOOKED;}

}
