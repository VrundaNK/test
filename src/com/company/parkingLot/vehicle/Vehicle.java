package com.company.parkingLot.vehicle;

import com.company.parkingLot.Level;
import com.company.parkingLot.ParkingSpot;
import com.company.parkingLot.SPOTSIZE;

import java.util.List;

/**
 * Created by vnagpurkar on 7/23/16.
 */
public abstract class Vehicle {

    protected VEHICLETYPE type;
    protected String numberPlate;
    protected SPOTSIZE spotsize;
    protected int spotsNeeded;
    protected List<ParkingSpot> parkingSpots = null;

    public VEHICLETYPE getType() {
        return type;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public List<ParkingSpot> getParkingSpot() {
        return parkingSpots;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        if(parkingSpots.size() <= spotsNeeded) {
            this.parkingSpots.add(parkingSpot);
        }
    }

    public abstract void updateVehicleInfo();

    public abstract boolean canFitInSpot(ParkingSpot parkingSpot);

    public abstract boolean park(List<Level> levels);

    public void unPark(ParkingSpot[] spots) {

        for(ParkingSpot spot : spots) {
            spot.clearParkingSpot();
        }
    }
}