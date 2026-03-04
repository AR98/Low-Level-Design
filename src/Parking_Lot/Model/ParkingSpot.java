package Parking_Lot.Model;

import Parking_Lot.Model.Enum.SpotType;
import Parking_Lot.Model.Enum.VehicleType;

import java.util.concurrent.locks.ReentrantLock;

public class ParkingSpot {
    private final VehicleType type;
    private final int id;
    private boolean occupied = false;
    private  final ReentrantLock  lock = new ReentrantLock();

    public ParkingSpot(int id, VehicleType type){
        this.type = type;
        this.id = id;
    }

    public void vacate() {
        lock.lock();
        try {
            this.occupied = false;
        } finally {
            lock.unlock();
        }
    }

    public boolean isOccupied() {
        return occupied;
    }

    public VehicleType getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public boolean reserve(VehicleType vehicleType){
        // If the type doesn't match, don't even try to lock
        if (this.type != vehicleType || this.occupied) {
            return false;
        }

        if(lock.tryLock()){
            try {
                // Double-check the status after acquiring lock (Atomic Check)
                if (!occupied) {
                    this.occupied = true;
                    return true;
                }
            } finally {
                lock.unlock();
            }
        }
        return  false;
    }
}
