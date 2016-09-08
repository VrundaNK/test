package com.company.parkingLot.vehicle;

import com.company.parkingLot.Level;
import com.company.parkingLot.ParkingSpot;
import com.company.parkingLot.SPOTSIZE;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vnagpurkar on 7/23/16.
 */
public class Bus extends Vehicle {

    public Bus (String numberPlate) {
        this.numberPlate = numberPlate;
        updateVehicleInfo();
    }

    @Override
    public void updateVehicleInfo() {
        type = VEHICLETYPE.BUS;
        spotsize = SPOTSIZE.LARGE;
        spotsNeeded = 5;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot availableParkingSpot) {

        if(availableParkingSpot.getSize() == SPOTSIZE.LARGE) {
            return true;
        }
        return false;
    }

    @Override
    public boolean park(List<Level> levels) {

        List<ParkingSpot> requiredSpots = new ArrayList<ParkingSpot>();
        for(Level level: levels) {
            if (!level.getSpots().isEmpty()) {
                List<ParkingSpot> availableSpots = level.getSpots();
                int spotNumber = availableSpots.get(0).getSpotNumber();
                requiredSpots.clear();
                for (ParkingSpot spot : availableSpots) {
                    if(requiredSpots.size() <= spotsNeeded &&
                            spot.getSpotNumber() - spotNumber == 1) { // spots are consecutive
                        spotNumber = spot.getSpotNumber();
                        if (this.canFitInSpot(spot)) {
                            requiredSpots.add(spot);
                        } else {
                            requiredSpots.clear();
                        }
                    } else {
                        requiredSpots.clear();
                    }
                }
            }
        }
        if(requiredSpots.isEmpty()) {
            return false;
        }
        for(ParkingSpot spot: requiredSpots) {
            spot.parkAVehicle(this);
        }
        return true;
    }
}
