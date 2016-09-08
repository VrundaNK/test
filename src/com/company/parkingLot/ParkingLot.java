package com.company.parkingLot;

import java.util.*;

/**
 * Created by vnagpurkar on 7/23/16.
 */
// 8.4 Design a parking lot using object-oriented principles
public class ParkingLot {

    private List<Level> spots; // each level contains different spots

    public ParkingLot() {

        spots = new ArrayList<Level>();
        init();
    }

    private void init() {

        initaliseParkingLot();
    }

    private void initaliseParkingLot() {
        Level level = new Level(1);
        List<ParkingSpot> spots = new ArrayList<ParkingSpot>();
        ParkingSpot spot = new ParkingSpot(SPOTSIZE.MOTORCYCLE, level, 0, 1);
        spots.add(spot);
        spot = new ParkingSpot(SPOTSIZE.MOTORCYCLE, level, 0, 2);
        spots.add(spot);
        spot = new ParkingSpot(SPOTSIZE.COMPACT, level, 0, 3);
        spots.add(spot);
        spot = new ParkingSpot(SPOTSIZE.LARGE, level, 0, 4);
        spots.add(spot);
        spot = new ParkingSpot(SPOTSIZE.COMPACT, level, 0, 5);
        spots.add(spot);
        spot = new ParkingSpot(SPOTSIZE.MOTORCYCLE, level, 0, 6);
        spots.add(spot);
        spot = new ParkingSpot(SPOTSIZE.MOTORCYCLE, level, 0, 7);
        spots.add(spot);
        spot = new ParkingSpot(SPOTSIZE.COMPACT, level, 0, 8);
        spots.add(spot);
        spot = new ParkingSpot(SPOTSIZE.MOTORCYCLE, level, 0, 9);
        spots.add(spot);
        spot = new ParkingSpot(SPOTSIZE.COMPACT, level, 0, 10);
        spots.add(spot);
        spot = new ParkingSpot(SPOTSIZE.COMPACT, level, 0, 11);
        spots.add(spot);
        spot = new ParkingSpot(SPOTSIZE.LARGE, level, 0, 12);
        spots.add(spot);
        spot = new ParkingSpot(SPOTSIZE.LARGE, level, 0, 13);
        spots.add(spot);
        spot = new ParkingSpot(SPOTSIZE.LARGE, level, 0, 14);
        spots.add(spot);
        spot = new ParkingSpot(SPOTSIZE.LARGE, level, 0, 15);
        spots.add(spot);
        spot = new ParkingSpot(SPOTSIZE.LARGE, level, 0, 16);
        spots.add(spot);
        spot = new ParkingSpot(SPOTSIZE.COMPACT, level, 0, 17);
        spots.add(spot);
        level.setSpots(spots);


        level = new Level(2);
        spots = new ArrayList<ParkingSpot>();
        spot = new ParkingSpot(SPOTSIZE.LARGE, level, 0, 1);
        spots.add(spot);
        spot = new ParkingSpot(SPOTSIZE.MOTORCYCLE, level, 0, 2);
        spots.add(spot);
        spot = new ParkingSpot(SPOTSIZE.COMPACT, level, 0, 3);
        spots.add(spot);
        spot = new ParkingSpot(SPOTSIZE.LARGE, level, 0, 4);
        spots.add(spot);
        spot = new ParkingSpot(SPOTSIZE.COMPACT, level, 0, 5);
        spots.add(spot);
        spot = new ParkingSpot(SPOTSIZE.MOTORCYCLE, level, 0, 6);
        spots.add(spot);
        spot = new ParkingSpot(SPOTSIZE.MOTORCYCLE, level, 0, 7);
        spots.add(spot);
        spot = new ParkingSpot(SPOTSIZE.COMPACT, level, 0, 8);
        spots.add(spot);
        spot = new ParkingSpot(SPOTSIZE.MOTORCYCLE, level, 0, 9);
        spots.add(spot);
        spot = new ParkingSpot(SPOTSIZE.COMPACT, level, 0, 10);
        spots.add(spot);
        spot = new ParkingSpot(SPOTSIZE.COMPACT, level, 0, 11);
        spots.add(spot);
        spot = new ParkingSpot(SPOTSIZE.LARGE, level, 0, 12);
        spots.add(spot);
        spot = new ParkingSpot(SPOTSIZE.LARGE, level, 0, 13);
        spots.add(spot);
        spot = new ParkingSpot(SPOTSIZE.LARGE, level, 0, 14);
        spots.add(spot);
        spot = new ParkingSpot(SPOTSIZE.LARGE, level, 0, 15);
        spots.add(spot);
        spot = new ParkingSpot(SPOTSIZE.LARGE, level, 0, 16);
        spots.add(spot);
        spot = new ParkingSpot(SPOTSIZE.COMPACT, level, 0, 17);
        spots.add(spot);
        level.setSpots(spots);

    }


}


