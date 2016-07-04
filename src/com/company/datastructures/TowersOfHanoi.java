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

        int n=4;
        Tower[] towers = init(3, n);

        // non-recursive
        towers[2]= moveDisks(towers[0], towers[1], towers[2], n-1);

        towers = init(3, n);
        // recursive
        towers[2]= moveDisksRecur(towers[0], towers[1], towers[2], n-1);
    }

    private static Tower moveDisks(Tower origin, Tower buffer, Tower destination, int n) {
        // move n-1 disks from origin (towers[0]) to buffer (towers[1])
        while(n>0) {
            origin.movdeDiskTopToTower(buffer);
            n--;
        }
        // move last disk (n) from origin (towers[0]) to destination (towers[2])
        origin.movdeDiskTopToTower(destination);
        // move all disks from buffer (towers[1]) to destination (towers[2])
        while(!buffer.isEmpty()) {
            buffer.movdeDiskTopToTower(destination);
        }
        return destination;
    }

    public static Tower moveDisksRecur(Tower origin, Tower buffer, Tower destination, int n) {

        if(n==0) {
            origin.movdeDiskTopToTower(destination);
        }
        if(n>0) {
            origin.movdeDiskTopToTower(buffer);
            destination = moveDisksRecur(origin, buffer, destination, n - 1);
        }
        if(!buffer.isEmpty()) {
            buffer.movdeDiskTopToTower(destination);
        }
        return destination;
    }

    private static Tower[] init(int towerSize, int n) {

        Tower[] towers = new Tower[towerSize];
        for(int i=0; i<3; i++) {
            Tower tower = new Tower(i, n);
            towers[i] = tower;
        }

        for(int i=n-1; i>=0; i--) {
            towers[0].addDisk(i);
        }
        return towers;
    }

}

class Tower {

    private int index;
    private int capacity;
    private java.util.Stack<Integer> disks;

    public Tower(int index, int capacity) {
        this.index = index;
        this.capacity = capacity;
        disks = new Stack<Integer>();
    }

    public void addDisk(int disk) {
        if(disk >= capacity) {
            throw new Error("Disk is full");
        }
        if(!disks.isEmpty() && disks.peek() == disk) {
            throw new Error("Same disk is already pushed to stack");
        }
        disks.push(disk);
    }

    public boolean isEmpty(){
        return this.disks.isEmpty();
    }

    public int popTopDisk() {
        return this.disks.pop();
    }

    public void movdeDiskTopToTower(Tower tower){
        if(this.isEmpty()) {
            throw new Error("Disk is Empty");
        }
        tower.addDisk(this.popTopDisk());
    }

}
