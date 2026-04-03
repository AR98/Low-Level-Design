package Movie_Booking.Model;

import Movie_Booking.Model.Enum.SeatStatus;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

public class ShowSeat {
    private Seat seat;
    private SeatStatus status = SeatStatus.AVAILABLE;
    private  final double price;
    private LocalDateTime lockExpiry;
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

    public boolean isActuallyAvailable() {
        if (status == SeatStatus.AVAILABLE) return true;
        if (status == SeatStatus.LOCKED && lockExpiry != null && LocalDateTime.now().isAfter(lockExpiry)) {
            return true;
        }
        return false;
    }

    public String getSeatId(){ return seat.id;}

    public  boolean lock(){ return lock.tryLock();}
    public void unLock(){ if (lock.isHeldByCurrentThread()) {
        lock.unlock();
    }}
    public void reserve(int minutes){
        status = SeatStatus.LOCKED;
        this.lockExpiry = LocalDateTime.now().plusMinutes(minutes);
    }
    public void confirm(){ status = SeatStatus.BOOKED;}
    public void release() { this.status = SeatStatus.AVAILABLE; this.lockExpiry = null; }
}
