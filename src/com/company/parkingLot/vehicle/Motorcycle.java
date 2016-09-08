package com.company.parkingLot.vehicle;

import com.company.parkingLot.Level;
import com.company.parkingLot.PARKINGSIGN;
import com.company.parkingLot.ParkingSpot;
import com.company.parkingLot.SPOTSIZE;

import java.util.List;

/**
 * Created by vnagpurkar on 7/23/16.
 */
public class Motorcycle extends Vehicle {


    public Motorcycle (String numberPlate) {
        this.numberPlate = numberPlate;
        updateVehicleInfo();
    }

    @Override
    public void updateVehicleInfo() {
        type = VEHICLETYPE.MOTORCYCLE;
        spotsize = SPOTSIZE.MOTORCYCLE;
        spotsNeeded = 1;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot availableParkingSpot) {

        // motorcycle can fit in any parking lot
        return true;
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
