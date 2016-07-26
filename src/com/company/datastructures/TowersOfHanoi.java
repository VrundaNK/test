package com.company.datastructures;

import java.util.Stack;

/**
 * Created by vnagpurkar on 7/3/16.
 */
public class TowersOfHanoi {

    // In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of
    // different sizes which can slide onto any tower. The puzzle starts with disks sorted
    // in ascending order of size from top to bottom (i.e., each disk sits on top of an even
    // larger one).
    // You have the following constraints:
    //      (1) Only one disk can be moved at a time.
    //      (2) A disk is slid off the top of one tower onto the next rod.
    //      (3) A disk can only be placed on top of a larger disk.
    // Write a program to move the disks from the first tower to the last using Stacks

    public static void moveDisks() {

        int n = 4;
        Tower[] towers = init(3, n);

        Tower t = moveDisks(n, towers[0], towers[2], towers[1]);

        Stack<Integer> disks = t.getDisks();
    }

    private static Tower moveDisks(int n, Tower origin, Tower destination, Tower buffer){

        if(n <= 0) return destination; // base case

        // move n-1 disks from origin (tower1) to buffer(tower2) using destination as buffer(tower3)
        moveDisks(n-1, origin, buffer, destination);

        // move top disk from origin to destination
        origin.moveTopToDestination(destination);

        // move n-1 disks from buffer(tower2) to destination(tower3) using origin(tower1) as buffer
        moveDisks(n-1, buffer, destination, origin);

        return destination;
    }

    private static Tower[] init(int size, int disks){

        Tower[] towers = new Tower[size];
        for(int i=0; i<size; i++){
            towers[i] = new Tower(i);
        }

        for(int i=disks-1; i>=0; i--){
            towers[0].addDisk(i);
        }
        return towers;
    }


}

class Tower {

    private int index;
    private Stack<Integer> disks;

    public Tower(int index) {

        this.index = index;
        disks = new Stack<Integer>();
    }

    public Stack<Integer> getDisks(){

        return this.disks;
    }


    public void addDisk(int disk){

        if(!disks.isEmpty() && disks.peek() <= disk) {
            throw new Error("something is wrong!!!!");
        }
        disks.push(disk);
    }

    public void moveTopToDestination(Tower destination) {

        if(this.disks.isEmpty()) {
            throw new Error("Something went wrong!!!!");
        }
        destination.addDisk(this.disks.pop());
    }

}

