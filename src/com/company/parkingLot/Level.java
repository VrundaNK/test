package com.company.parkingLot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vnagpurkar on 7/23/16.
 */
public class Level {

    private int index;
    private List<ParkingSpot> spots;
    private List<ParkingSpot> occupied;
    private PARKINGSIGN parkingsign;

    public Level(int index) {

        this.index = index;
        spots = new ArrayList<ParkingSpot>();
        occupied = new ArrayList<ParkingSpot>();
        parkingsign = PARKINGSIGN.NORMAL;
    }

    public int getIndex() {
        return index;
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }

    public void setSpots(List<ParkingSpot> spots) {
        this.spots = spots;
    }

    public PARKINGSIGN getParkingsign(){
        return this.parkingsign;
    }

    public void park(ParkingSpot spot){
        spots.remove(spot);
        occupied.add(spot);
        if (spots.isEmpty()) {
            parkingsign = PARKINGSIGN.FULL;
        }
    }

    public void unPark(ParkingSpot spot){
        spots.add(spot);
        occupied.remove(spot);
        if (occupied.isEmpty()) {
            parkingsign = PARKINGSIGN.EMPTY;
        }
    }

}
