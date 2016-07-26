package com.company.parkingLot.vehicle;

import com.company.parkingLot.Level;
import com.company.parkingLot.PARKINGSIGN;
import com.company.parkingLot.ParkingSpot;
import com.company.parkingLot.SPOTSIZE;

import java.util.List;

/**
 * Created by vnagpurkar on 7/23/16.
 */
public class Car extends Vehicle {

    public Car (String numberPlate) {
        this.numberPlate = numberPlate;
        updateVehicleInfo();
    }

    @Override
    public void updateVehicleInfo() {
        type = VEHICLETYPE.CAR;
        spotsize = SPOTSIZE.COMPACT;
        spotsNeeded = 1;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot parkingSpot) {

        // car only fits in if parking lot size is compact or large
       if(parkingSpot.getSize().compareTo(spotsize) >=1) {
           return true;
       }
        return false;
    }

    @Override
    public boolean park(List<Level> levels) {

        for(Level level: levels) {
            // parking level is not full
            if (level.getParkingsign() != PARKINGSIGN.FULL) {

                List<ParkingSpot> availableSpots = level.getSpots();
                for(ParkingSpot spot: availableSpots) {
                    if(canFitInSpot(spot)) {
                        spot.parkAVehicle(this);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
