package com.company.parkingLot;

import com.company.parkingLot.vehicle.Vehicle;

/**
 * Created by vnagpurkar on 7/23/16.
 */
public class ParkingSpot {

    private SPOTSIZE size;
    private Level level;
    private int spotNumber;
    private boolean isAvailable = true;
    private Vehicle vehicle;

    public ParkingSpot(SPOTSIZE size, Level level, int row, int spotNumber){

        this.size = size;
        this.level = level;
        this.spotNumber = spotNumber;
    }

    public SPOTSIZE getSize() {
        return this.size;
    }

    public Level getLevel() {
        return this.level;
    }

    public int getSpotNumber() {
        return this.spotNumber;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void parkAVehicle(Vehicle vehicle) {

        this.isAvailable = false;
        this.vehicle = vehicle;
        this.vehicle.setParkingSpot(this);
        this.level.park(this);
    }

    public void clearParkingSpot() {
        this.isAvailable = true;
        this.vehicle.setParkingSpot(null);
        this.vehicle = null;
        this.level.unPark(this);
    }
}
